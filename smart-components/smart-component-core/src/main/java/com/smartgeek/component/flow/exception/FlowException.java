package com.smartgeek.component.flow.exception;

import lombok.Data;

/**
 * @author cys
 * @date 2022/9/21 11:09
 * @description:
 */
@Data
public class FlowException  extends RuntimeException{

    private static String MSG_FORMAT = "[msgCode=%s, msgContent=%s]";
    private String msgCode;
    private String msgContent;

    public FlowException() {
    }


    public FlowException(String msgCode) {
        this(msgCode, (String)null);
    }

    public FlowException(String msgCode, String msgContent) {
        this(msgCode, msgContent, (Throwable)null);
    }

    public FlowException(String msgCode, Throwable cause) {
        this(msgCode, (String)null, cause);
    }

    public FlowException(String msgCode, String msgContent, Throwable cause) {
        super(String.format(MSG_FORMAT, msgCode, msgContent), cause);
        this.msgCode = msgCode;
        this.msgContent = msgContent;
    }



}
