package com.smartgeek.component.flow.exception;

import com.smartgeek.component.flow.engine.WorkContext;
import lombok.Data;

/**
 * 流执行异常
 *
 * @author cys
 * @date 2022/9/21 13:51
 * @description:
 */
@Data
public class FlowExecutionException extends Exception{
    private static final String MSG_FORMAT = "流程引擎执行流程%s的%s节点时失败";

    private String flowName;
    private String nodeName;
    private WorkContext context;


    public FlowExecutionException(String flowName, String nodeName, WorkContext context) {
        super(getMsg(flowName, nodeName));
        this.flowName = flowName;
        this.nodeName = nodeName;
        this.context = context;
    }


    private static String getMsg(String flowName, String nodeName) {
        return String.format("流程引擎执行流程%s的%s节点时失败", flowName, nodeName);
    }


}
