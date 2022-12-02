package com.smartgeek.component.web.model.base;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

/**
 * SubBase 基类
 *
 * @param <S> SubEntity
 * @author cys
 */
public class SubBaseEntity<S> extends BaseEntity {

    /** 子数据集合 */
    @TableField(exist = false)
    private List<S> subList;

    public List<S> getSubList() {
        return subList;
    }

    public void setSubList(List<S> subList) {
        this.subList = subList;
    }
}
