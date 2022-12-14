package com.smartgeek.component.web.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.smartgeek.component.validate.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Basis 基类
 *
 * @author cys
 */
public class BasisEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Id */
    @TableId("id")
    private Long id;

    /** 数据源名称 */
    @TableField(exist = false)
    private String sourceName;

    /** 请求参数 */
    @TableField(exist = false)
    private Map<String, Object> params;

    @NotNull(message = "id不能为空", groups = {UpdateGroup.class})
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Map<String, Object> getParams() {
        return params == null ? new HashMap<>() : params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
