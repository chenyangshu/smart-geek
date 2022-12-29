package com.smartgeek.component.command;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.dto.Response;

/**
 * @author cys
 * @date 2022/11/27 11:34
 * @description:
 */
public interface CommandExecutorI<R extends Response,C extends Command>  extends CommonCommandExecutorI {
    R execute(C cmd);
}
