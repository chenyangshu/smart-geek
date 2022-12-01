package com.smartgeek.component.flow.engine;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 流处理上下文
 *
 * @author treeyschen
 * @date 2022/09/21
 */
public class FlowHandleContext<T> implements Serializable {

    /**
     * 输入数据
     */
    private T inputData;
    /**
     * 上下文
     */
    private Map<String, Object> context;

    private FlowHandleContext() {
    }

    public FlowHandleContext(T inputData, Map<String, Object> context) {
        //流程处理输入的参数不能为null
        Assert.notNull(inputData, "The parameters of the process processing input cannot be null");
        this.inputData = inputData;
        this.context = context;
        if (this.context == null) {
            this.context = new ConcurrentHashMap();
        }
    }

    public FlowHandleContext(T inputData) {
        this(inputData, (Map) null);
    }


    public T getInputData() {
        return this.inputData;
    }

    public void setInputData(T inputData) {
        this.inputData = inputData;
    }

    public Map<String, Object> getContext() {
        return Collections.unmodifiableMap(this.context);
    }

    public void setContext(Map<String, Object> context) {
        this.context = (Map) (context == null ? new ConcurrentHashMap() : context);
    }

    public void refreshTarget(T inputData) {
        Assert.notNull(inputData, "目标对象不能为null");
        this.inputData = inputData;
    }

    public <V> V getContextAttr(String key) {
        return (V) this.context.get(key);
    }

    public void setContextAttr(String key, Object value) {
        this.context.put(key, value);
    }


    public <V> V getContextAttr(Class<V> valueBeanClazz) {
        Object value = this.context.get(valueBeanClazz.getName());
        if (ObjectUtil.isNotNull(value) && value.getClass().equals(valueBeanClazz)) {
            return (V) value;
        }
        return null;
    }


    public <V> void setContextAttr(V value) {
        Assert.notNull(value, "value对象不能为null");
        this.context.put(value.getClass().getName(), value);
    }


    public String toString() {
        return "FlowHandleContext(inputData=" + this.getInputData() + ", context=" + this.getContext() + ")";
    }

}
