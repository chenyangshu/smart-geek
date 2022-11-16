package com.smartgeek.component.flow.exception;

/**
 * @author cys
 * @date 2022/9/21 15:20
 * @description:
 */
public class ExceptionUtil {

    public ExceptionUtil() {
    }

    public static <R> R rethrow(final Throwable throwable) {
        return typeErasure(throwable);
    }

    private static <R, T extends Throwable> R typeErasure(final Throwable throwable) throws T {
        throw (T) throwable;
    }


}
