///*
// * 作者：钟勋 (e-mail:zhongxunking@163.com)
// */
//
///*
// * 修订记录:
// * @author 钟勋 2017-04-04 19:09 创建
// */
//package com.smartgeek.component.flow.work;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
///**
// * 方法执行器
// */
//@AllArgsConstructor
//@Getter
//public abstract class MethodExecutor {
//    // 方法
//    private final Method method;
//
//    /**
//     * 执行方法
//     *
//     * @param obj  被执行的对象
//     * @param args 需传入目标方法的参数
//     * @return 方法返回的结果
//     * @throws Throwable 执行过程中发生任何异常都会往外抛
//     */
//    protected Object execute(Object obj, Object[] args) throws Throwable {
//        try {
//            return method.invoke(obj, args);
//        } catch (InvocationTargetException e) {
//            // 抛出原始异常
//            throw e.getTargetException();
//        }
//    }
//
//    /**
//     * 获取方法入参类型
//     */
//    public Class<?>[] getParameterTypes() {
//        return method.getParameterTypes();
//    }
//
//    /**
//     * 获取方法返回类型
//     */
//    public Class<?> getReturnType() {
//        return method.getReturnType();
//    }
//}
