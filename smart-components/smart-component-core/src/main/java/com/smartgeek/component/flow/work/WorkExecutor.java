//package com.smartgeek.component.flow.work;
//
//import lombok.Getter;
//
//import java.lang.reflect.Method;
//
///**
// * @author cys
// * @date 2022/11/16 12:01
// * @description:
// */
//@Getter
//public class WorkExecutor extends MethodExecutor{
//
//    // 处理器名称
//    private final String workName;
//    // 处理器
//    private final Work work;
//
//    public WorkExecutor( Work work, Method executeMethod) {
//        super(executeMethod);
//        this.workName = work.getName();
//        this.work = work;
//    }
//
//    /**
//     * 执行处理器
//     *
//     * @param context 流程上下文
//     * @return Execute类型方法返回的结果
//     * @throws Throwable 执行过程中发生任何异常都后会往外抛
//     */
//    public Object execute(WorkContext<?> context) throws Throwable {
//        return execute(processor, new Object[]{context});
//    }
//
//
//}
