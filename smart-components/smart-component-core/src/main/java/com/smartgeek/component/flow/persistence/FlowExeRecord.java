package com.smartgeek.component.flow.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cys
 * @date 2022/9/21 13:22
 * @description:
 */
@Data
public class FlowExeRecord implements Serializable {
    /**
     * 应用程序id
     */
    private String appId;
    /**
     * 流名字
     */
    private String flowName;
    /**
     * 流id
     */
    private String flowId;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 上下文
     */
    private Object context;
    /**
     * 备忘录
     */
    private String memo;
}
