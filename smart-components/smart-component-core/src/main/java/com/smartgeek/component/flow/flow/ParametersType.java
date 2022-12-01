package com.smartgeek.component.flow.flow;

/**
 * @author cys
 * @date 2022/9/21 14:07
 * @description:
 */
public enum ParametersType {
    /**
     * 没有
     */
    NONE,
    /**
     * 只有过程结果
     */
    ONLY_PROCESS_RESULT,
    /**
     * 只有目标上下文
     */
    ONLY_TARGET_CONTEXT,
    /**
     * 过程结果和目标上下文
     */
    PROCESS_RESULT_AND_TARGET_CONTEXT;

    private ParametersType() {
    }
}
