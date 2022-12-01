package com.smartgeek.component.flow.processor;

import com.smartgeek.component.flow.annotation.processor.Processor;
import com.smartgeek.component.flow.engine.FlowHandleContext;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * 处理器解析器
 *
 * @author cys
 * @date 2022/9/21 11:17
 * @description:
 */
public class ProcessorParser {

    private static final Logger log = LoggerFactory.getLogger(ProcessorParser.class);

    public ProcessorParser() {
    }


    /**
     * 解析处理器
     *
     * @param processor 处理器
     * @return {@link ProcessorExecutor}
     */
    public static ProcessorExecutor parseProcessor(NodeProcessor processor) {
        Class<?> processorClass = AopUtils.getTargetClass(processor);
        log.debug("解析处理器：{}", ClassUtils.getQualifiedName(processorClass));
        //通过注解获取处理器名
        String processorName = (processorClass.getAnnotation(Processor.class)).name();
        if (StringUtils.isEmpty(processorName)) {
            processorName = ClassUtils.getShortNameAsProperty(processorClass);
        }

        final String processorNameFinal = processorName;
        ProcessorExecutor processorExecutor = new ProcessorExecutor(processorName, processor);
        Try.run(() -> {
            Method method = processorClass.getDeclaredMethod("execute", FlowHandleContext.class);
            processorExecutor.setMethodExecutor(parseProcessorMethod(method));
        }).onFailure(Exception.class, item -> {
            log.warn("处理器:{}-解析处理器方法异常", processorNameFinal);
            new IllegalStateException("处理器" + processorNameFinal + "解析处理器方法异常");
        });
        processorExecutor.validate();
        return processorExecutor;
    }


    /**
     * 解析处理方法
     *
     * @param method 方法
     * @return {@link ProcessorExecutor.ProcessorBaseMethodExecutor}
     */
    private static ProcessorExecutor.ProcessorBaseMethodExecutor parseProcessorMethod(Method method) {
        log.debug("解析处理器方法：{}", method);
        if (!Modifier.isPublic(method.getModifiers())) {
            throw new IllegalArgumentException("处理器方法" + ClassUtils.getQualifiedMethodName(method) + "必须是public类型");
        } else {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1) {
                throw new IllegalArgumentException("处理器方法" + ClassUtils.getQualifiedMethodName(method) + "入参必须是（FlowHandleContext）");
            } else if (parameterTypes[0] != FlowHandleContext.class) {
                throw new IllegalArgumentException("处理器方法" + ClassUtils.getQualifiedMethodName(method) + "入参必须是（FlowHandleContext）");
            } else {
                ResolvableType resolvableType = ResolvableType.forMethodParameter(method, 0);
                Class classOfTarget = resolvableType.getGeneric(new int[]{0}).resolve(Object.class);
                return new ProcessorExecutor.ProcessorBaseMethodExecutor(method, classOfTarget);
            }
        }
    }


}
