//package com.smartgeek.component.flow.work;
//
//import io.vavr.control.Try;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.support.AopUtils;
//import org.springframework.util.ClassUtils;
//
//import java.lang.reflect.Method;
//
///**
// * @author cys
// * @date 2022/11/16 14:06
// * @description:
// */
//public class WorkParser {
//
//    private static final Logger log = LoggerFactory.getLogger(WorkParser.class);
//
//    public WorkParser() {
//    }
//
//    /**
//     * 解析处理器
//     *
//     * @param work 处理器
//     * @return {@link WorkExecutor}
//     */
//    public static WorkExecutor parseWork(Work work) {
//        Class<?> processorClass = AopUtils.getTargetClass(work);
//        log.debug("解析处理器：{}", ClassUtils.getQualifiedName(processorClass));
//        //通过注解获取处理器名
//        final String processorNameFinal = processorName;
//        WorkExecutor workExecutor = Try.of(() -> {
//            Method method = processorClass.getDeclaredMethod("execute", WorkContext.class);
//            return new WorkExecutor(processorName, work, method);
//        }).onFailure(Exception.class, item -> {
//            log.warn("处理器:{}-解析处理器方法异常", processorNameFinal);
//            new IllegalStateException("处理器" + processorNameFinal + "解析处理器方法异常");
//        }).get();
//        return workExecutor;
//    }
//}
