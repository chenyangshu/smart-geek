package com.smartgeek.bizwork.common.core.exception;

public class SystemException extends RuntimeException {

    private String msg;

    public SystemException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
