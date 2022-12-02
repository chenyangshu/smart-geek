package com.smartgeek.component.flow.transaction;

import com.smartgeek.component.flow.annotation.flow.Flow;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author cys
 * @date 2022/9/21 12:46
 * @description:
 */

@Component
public class FlowTxsHolder {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired(required = false)
    private PlatformTransactionManager transactionManager;
    private Map<String, FlowTxExecutor> flowTxExecutorMap = new HashMap();

    public FlowTxsHolder() {
    }


    @PostConstruct
    public void init() {
        String[] flowBeanNames = this.applicationContext.getBeanNamesForAnnotation(Flow.class);
        for (String flowBeanName : flowBeanNames) {
            Object flow = this.applicationContext.getBean(flowBeanName);
            Class<?> flowClass = AopUtils.getTargetClass(flow);
            Flow flowAnnotation = flowClass.getAnnotation(Flow.class);
            String flowName = flowAnnotation.name();
            if (StringUtils.isEmpty(flowName)) {
                flowName = ClassUtils.getShortNameAsProperty(flowClass);
            }

            if (flowAnnotation.enableFlowTx()) {
                FlowTxExecutor flowTxExecutor = FlowTxParser.parseFlowTx(flowName, this.getTxManager(flowName, flowAnnotation.txManager()));
                if (this.flowTxExecutorMap.containsKey(flowTxExecutor.getFlow())) {
                    throw new RuntimeException("流程" + flowTxExecutor.getFlow() + "存在多个流程事务");
                }
                this.flowTxExecutorMap.put(flowTxExecutor.getFlow(), flowTxExecutor);
            }


        }
    }

    /**
     * 得到tx经理
     *
     * @param flowName          流名字
     * @param txManagerBeanName tx manager bean名称
     * @return {@link PlatformTransactionManager}
     */
    protected PlatformTransactionManager getTxManager(String flowName, String txManagerBeanName) {
        PlatformTransactionManager txManager = null;

        if (StringUtils.isEmpty(txManagerBeanName)) {
            txManager = this.transactionManager;
        } else {
            txManager = Try.of(() -> (PlatformTransactionManager) this.applicationContext.getBean(txManagerBeanName)).onFailure(NoSuchBeanDefinitionException.class, e -> new IllegalArgumentException("流程" + flowName + ": 不存名称为" + txManagerBeanName + "的事务管理器"))
                    .onFailure(ClassCastException.class, e -> new IllegalArgumentException("流程" + flowName + ": 名称为" + txManagerBeanName + "的bean，类型不是PlatformTransactionManager"))
                    .onFailure(Exception.class, e -> new IllegalArgumentException("流程" + flowName + ": 请检查事务管理器" + txManagerBeanName + "是否正常配置"))
                    .getOrNull();
        }

        Assert.notNull(txManager, "流程" + flowName + ": 开启了流程事务，但没有找到事务管理器，请检查配置");
        return txManager;

    }


    public Set<String> getFlowNames() {
        return this.flowTxExecutorMap.keySet();
    }

    public FlowTxExecutor getRequiredFlowTxExecutor(String flow) {
        if (!this.flowTxExecutorMap.containsKey(flow)) {
            throw new IllegalArgumentException("不存在流程" + flow + "的流程事务");
        } else {
            return (FlowTxExecutor) this.flowTxExecutorMap.get(flow);
        }
    }


}
