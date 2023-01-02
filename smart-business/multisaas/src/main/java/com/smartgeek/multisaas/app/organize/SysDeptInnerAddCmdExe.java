package com.smartgeek.multisaas.app.organize;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class SysDeptInnerAddCmdExe implements CommandExecutorI<Response, SysDeptInnerAddCmd> {

    @Override
    public Response execute(SysDeptInnerAddCmd cmd) {
        return null;

    }
}
