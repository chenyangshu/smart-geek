package com.smartgeek.component.command;

/**
 * @author cys
 * @date 2022/11/27 11:35
 * @description:
 */
public interface CommandExecutorWithoutInputI<R>  extends CommonCommandExecutorI{
    R execute();
}
