package com.smartgeek.component.command;

/**
 * @author cys
 * @date 2022/11/27 11:34
 * @description:
 */
public interface CommandExecutorI<R,C>  extends CommonCommandExecutorI {
    R execute(C cmd);
}
