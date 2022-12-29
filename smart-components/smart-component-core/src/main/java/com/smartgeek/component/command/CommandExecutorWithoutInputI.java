package com.smartgeek.component.command;

import com.alibaba.cola.dto.Response;

/**
 * @author cys
 * @date 2022/11/27 11:35
 * @description:
 */
public interface CommandExecutorWithoutInputI<R extends Response>  extends CommonCommandExecutorI{
    R execute();
}
