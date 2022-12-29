package com.smartgeek.component.command;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.dto.Response;

/**
 * @author cys
 * @date 2022/11/27 11:37
 * @description:
 */
public interface QueryExecutorI<R extends Response,C extends Command>  extends CommandExecutorI<R , C> {
}
