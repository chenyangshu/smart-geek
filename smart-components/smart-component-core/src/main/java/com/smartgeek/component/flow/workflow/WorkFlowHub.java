package com.smartgeek.component.flow.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cys
 * @date 2022/11/17 17:53
 * @description:
 */
public class WorkFlowHub {
    private static final Logger LOG = LoggerFactory.getLogger(WorkFlowHub.class);

    // 元素集
    private static final Map<String, AbstractWorkFlow> elementMap = new ConcurrentHashMap<>();



    /**
     * 注册元素
     *
     * @param element 被注册的元素
     * @return 被替换的元素
     */
    public static AbstractWorkFlow register(AbstractWorkFlow element) {
        if (WorkFlowHub.containsKey(element.getName())) {
            throw new RuntimeException("存在重名的流程" + element.getName());
        }
        return elementMap.put(element.getName(), element);
    }

    /**
     * 获取所有元素的名称
     *
     * @return 所有所有元素的名称
     */
    public static Set<String> getNames() {
        return Collections.unmodifiableSet(elementMap.keySet());
    }

    /**
     * 获取元素
     *
     * @param name 元素名称
     * @return 元素
     */
    public static AbstractWorkFlow get(String name) {
        return elementMap.get(name);
    }


    public static boolean containsKey(String name){
        return elementMap.containsKey(name);
    }


}
