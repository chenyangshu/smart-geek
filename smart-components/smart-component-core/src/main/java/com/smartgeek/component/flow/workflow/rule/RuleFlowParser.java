package com.smartgeek.component.flow.workflow.rule;

import cn.hutool.core.util.StrUtil;
import com.smartgeek.component.flow.annotation.flow.Flow;
import com.smartgeek.component.flow.annotation.node.EndNode;
import com.smartgeek.component.flow.annotation.node.Node;
import com.smartgeek.component.flow.annotation.node.StartNode;
import com.smartgeek.component.flow.engine.WorkContext;
import com.smartgeek.component.flow.processor.*;
import com.smartgeek.component.flow.transaction.WorkFlowTxsHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author cys
 * @date 2022/9/21 13:15
 * @description:
 */
public class RuleFlowParser {

    private static final Logger logger = LoggerFactory.getLogger(RuleFlowParser.class);

    public RuleFlowParser() {
    }


    /**
     * 解析流程
     *
     * @param flow             流
     * @param nodeProcessorHub 节点处理中心
     * @param flowTxsHolder    流tx持有人
     * @return {@link RuleFlowExecutor}
     */
    public static RuleFlowExecutor parseFlow(Object flow, NodeProcessorHub nodeProcessorHub, WorkFlowTxsHolder flowTxsHolder) {
        Class<?> flowClass = AopUtils.getTargetClass(flow);
        logger.debug("解析流程：{}", ClassUtils.getQualifiedName(flowClass));
        Flow flowAnnotation = (Flow) flowClass.getAnnotation(Flow.class);
        String flowName = flowAnnotation.name();
        if (StrUtil.isEmpty(flowName)) {
            flowName = ClassUtils.getShortNameAsProperty(flowClass);
        }


        RuleFlowExecutor ruleFlowExecutor = new RuleFlowExecutor(flowName, flowAnnotation.enableFlowTx(), flow);
        if (flowAnnotation.enableFlowTx()) {
            ruleFlowExecutor.setFlowTxExecutor(flowTxsHolder.getRequiredFlowTxExecutor(flowName));
        }


        for (Method method : flowClass.getDeclaredMethods()) {
            Node nodeAnnotation = AnnotatedElementUtils.findMergedAnnotation(method, Node.class);

            if (nodeAnnotation != null) {
                NodeExecutor nodeExecutor = parseNode(nodeAnnotation, method, nodeProcessorHub);
                ruleFlowExecutor.addNode(nodeExecutor);
                if (method.isAnnotationPresent(StartNode.class)) {
                    ruleFlowExecutor.setStartNode(nodeExecutor.getNodeName());
                }

                if (method.isAnnotationPresent(EndNode.class)) {
                    ruleFlowExecutor.addEndNode(nodeExecutor.getNodeName());
                }
            }
        }

        ruleFlowExecutor.validate();
        return ruleFlowExecutor;

    }


    /**
     * 解析节点
     *
     * @param nodeAnnotation   节点注释
     * @param method           方法
     * @param nodeProcessorHub 节点处理中心
     * @return {@link NodeExecutor}
     */
    private static NodeExecutor parseNode(Node nodeAnnotation, Method method, NodeProcessorHub nodeProcessorHub) {
        logger.debug("解析流程节点：node={}，method={}", nodeAnnotation, method);
        String nodeName = nodeAnnotation.name();
        if (StrUtil.isEmpty(nodeName)) {
            nodeName = method.getName();
        }

        ProcessorExecutor processorExecutor = null;
        if (StrUtil.isNotEmpty(nodeAnnotation.handler())) {
            processorExecutor = nodeProcessorHub.getRequiredProcessorExecutor(nodeAnnotation.handler());
        }

        NodeExecutor nodeExecutor = new NodeExecutor(nodeName, processorExecutor, nodeAnnotation.autoExecute(), nodeAnnotation.enableNodeTx());
        nodeExecutor.setNodeDeciderExecutor(parseNodeDecider(method, processorExecutor));
        nodeExecutor.validate();
        return nodeExecutor;
    }


    /**
     * 解析节点决策器
     *
     * @param method            方法
     * @param processorExecutor 处理器执行程序
     * @return {@link NodeDeciderExecutorBase}
     */
    private static NodeDeciderExecutorBase parseNodeDecider(Method method, ProcessorExecutor processorExecutor) {
        logger.debug("解析节点决策器：{}", method);
        if (!Modifier.isPublic(method.getModifiers())) {
            throw new IllegalArgumentException("解析节点决策器" + ClassUtils.getQualifiedMethodName(method) + "必须是public类型");
        }


        Class classOfTarget = null;
        Class[] parameterTypes = method.getParameterTypes();
        ParametersType parametersType;
        if (parameterTypes.length == 0) {
            parametersType = ParametersType.NONE;
        } else {
            if (method.isAnnotationPresent(EndNode.class)) {
                throw new IllegalArgumentException("结束节点的决策器" + ClassUtils.getQualifiedMethodName(method) + "不能有入参");
            }

            ResolvableType resolvableType;
            if (parameterTypes.length == 1) {
                if (parameterTypes[0] == WorkContext.class) {
                    parametersType = ParametersType.ONLY_TARGET_CONTEXT;
                    resolvableType = ResolvableType.forMethodParameter(method, 0);
                    classOfTarget = resolvableType.getGeneric(new int[]{0}).resolve(Object.class);
                } else {
                    if (processorExecutor == null) {
                        throw new IllegalArgumentException("节点决策器" + ClassUtils.getQualifiedMethodName(method) + "不能有非TargetContext入参，因为这个节点没有处理器");
                    }

                    if (!parameterTypes[0].isAssignableFrom(processorExecutor.getReturnType())) {
                        throw new IllegalArgumentException("节点决策器" + ClassUtils.getQualifiedMethodName(method) + "的非TargetContext入参类型必须能被其处理器返回类型赋值, 节点决策器入参：" + parameterTypes[0].toString() + ", 处理器出参：" + processorExecutor.getReturnType().toString());
                    }

                    parametersType = ParametersType.ONLY_PROCESS_RESULT;
                }
            } else {
                if (parameterTypes.length != 2) {
                    throw new IllegalArgumentException("节点决策器" + ClassUtils.getQualifiedMethodName(method) + "的入参个数不能超过2个");
                }

                if (processorExecutor == null) {
                    throw new IllegalArgumentException("节点决策器" + ClassUtils.getQualifiedMethodName(method) + "不能有非TargetContext入参，因为这个节点没有处理器");
                }

                if (!parameterTypes[0].isAssignableFrom(processorExecutor.getReturnType())) {
                    throw new IllegalArgumentException("节点决策器" + ClassUtils.getQualifiedMethodName(method) + "的非TargetContext入参类型必须能被其处理器返回类型赋值");
                }

                if (parameterTypes[1] != WorkContext.class) {
                    throw new IllegalArgumentException("节点决策器" + ClassUtils.getQualifiedMethodName(method) + "的第二个参数类型必须是TargetContext");
                }

                parametersType = ParametersType.PROCESS_RESULT_AND_TARGET_CONTEXT;
                resolvableType = ResolvableType.forMethodParameter(method, 1);
                classOfTarget = resolvableType.getGeneric(new int[]{0}).resolve(Object.class);
            }
        }

        if (method.isAnnotationPresent(EndNode.class)) {
            if (method.getReturnType() != Void.TYPE) {
                throw new IllegalArgumentException("结束节点的节点决策器" + ClassUtils.getQualifiedMethodName(method) + "的返回类型必须是void");
            }
        } else if (method.getReturnType() != String.class) {
            throw new IllegalArgumentException("节点决策器" + ClassUtils.getQualifiedMethodName(method) + "的返回类型必须是String");
        }

        return new NodeDeciderExecutorBase(method, parametersType, classOfTarget);


    }


}
