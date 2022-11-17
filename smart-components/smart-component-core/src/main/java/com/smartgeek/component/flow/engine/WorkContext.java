package com.smartgeek.component.flow.engine;

import cn.hutool.core.util.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;


import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cys
 * @date 2022/11/15 9:37
 * @description:
 */

@AllArgsConstructor
@Getter
public class WorkContext<T> implements Serializable {

    // 目标对象
    private T target;

    // 附件（可往里面设值，可传递一些附加信息）
    private final Map<String, Object> attachmentMap = new ConcurrentHashMap<>();

    /**
     * 刷新目标对象
     *
     * @param newTarget 新的目标对象
     */
    public void refreshTarget(T newTarget) {
        Assert.notNull(newTarget, "目标对象不能为null");
        this.target = newTarget;
    }


    public <V> V getAttachmentBean(Class<V> valueBeanClazz) {
        Object value = this.attachmentMap.get(valueBeanClazz.getName());
        if (ObjectUtil.isNotNull(value) && value.getClass().equals(valueBeanClazz)) {
            return (V) value;
        }
        return null;
    }


    public <V> void addAttachmentBean(V value) {
        Assert.notNull(value, "value对象不能为null");
        this.attachmentMap.put(value.getClass().getName(),value);
    }

    public void putAttachment(String key, Object value) {
        attachmentMap.put(key, value);
    }

    public Object getAttachment(String key) {
        return attachmentMap.get(key);
    }

    public Set<Map.Entry<String, Object>> getEntrySet() {
        return attachmentMap.entrySet();
    }



}
