package com.smartgeek.component.flow.method;

import com.smartgeek.component.flow.annotation.node.NextNodeRoute;
import com.smartgeek.component.flow.annotation.node.ProcessNode;
import com.smartgeek.component.flow.annotation.node.StartNode;
import io.vavr.control.Try;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 基本方法执行程序
 *
 * @author cys
 * @date 2022/9/21 11:20
 * @description:
 */
public abstract class BaseMethodExecutor {

    private Method targetMethod;

    public BaseMethodExecutor(Method targetMethod) {
        this.targetMethod = targetMethod;
    }

    protected Object execute(Object processor, Object[] flowHandleContexts) throws Throwable {
        return Try.of(() -> {

                    Object result = this.targetMethod.invoke(processor, flowHandleContexts);
                    NextNodeRoute[] nextNodeRoutes = new NextNodeRoute[0];

                    //是否为开始节点
                    boolean hasStartNodeAnnotation = this.targetMethod.isAnnotationPresent(StartNode.class);
                    if (hasStartNodeAnnotation) {
                        StartNode processNode = this.targetMethod.getAnnotation(StartNode.class);
                        nextNodeRoutes = processNode.nextNodeRoute();
                    }

                    //是否为执行节点
                    boolean hasProcessNodeAnnotation = this.targetMethod.isAnnotationPresent(ProcessNode.class);
                    if (hasProcessNodeAnnotation) {
                        ProcessNode processNode = this.targetMethod.getAnnotation(ProcessNode.class);
                        nextNodeRoutes=processNode.nextNodeRoute();
                    }

                    //获取下一个节点名路由
                    if (null != nextNodeRoutes && nextNodeRoutes.length > 0) {
                        for (NextNodeRoute nextNodeRoute : nextNodeRoutes) {
                            if (nextNodeRoute.key().equals(result)) {
                                result = nextNodeRoute.nodeName();
                            }
                        }
                    }
                    return result;
                })
                .onFailure(InvocationTargetException.class, item -> item.getTargetException())
                .getOrNull();
    }

    public Class[] getParameterTypes() {
        return this.targetMethod.getParameterTypes();
    }

    public Class getReturnType() {
        return this.targetMethod.getReturnType();
    }


}
