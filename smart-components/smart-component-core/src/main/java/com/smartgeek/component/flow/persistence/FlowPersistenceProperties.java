package com.smartgeek.component.flow.persistence;

import lombok.Data;

/**
 * @author cys
 * @date 2022/9/21 13:22
 * @description:
 */
@Data
public class FlowPersistenceProperties {
    /**
     * 是持久化
     */
    private boolean isPersistence = false;
    /**
     * 数据源名称
     */
    private String dataSourceName;
}
