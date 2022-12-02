package com.smartgeek.component.web.model.base;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

/**
 * SubTree 基类
 *
 * @param <D>  Entity
 * @param <SD> SubEntity
 * @author cys
 */
public class SubTreeEntity<D, SD> extends TreeEntity<D> {

    /** 子数据集合 */
    @TableField(exist = false)
    private List<SD> subList;

    public List<SD> getSubList() {
        return subList;
    }

    public void setSubList(List<SD> subList) {
        this.subList = subList;
    }
}
