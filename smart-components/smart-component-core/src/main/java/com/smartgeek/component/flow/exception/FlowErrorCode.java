package com.smartgeek.component.flow.exception;

/**
 * @author cys
 * @date 2022/9/21 11:12
 * @description:
 */
public enum FlowErrorCode {
    NODE_PROCESSOR_DUPLICATE_NAME("Flow-500", "节点处理器重名"),
    NODE_PROCESSOR_NOT_IMPLEMENT_INTERFACE("Flow-501", "节点处理器未实现NodeProcessor接口");
    ;

    private String errCode;
    private String errDesc;

    private FlowErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrDesc() {
        return this.errDesc;
    }



}
