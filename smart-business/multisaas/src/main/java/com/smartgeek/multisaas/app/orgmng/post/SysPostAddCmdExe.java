package com.smartgeek.multisaas.app.orgmng.post;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorI;
import com.smartgeek.multisaas.app.orgmng.dept.SysDeptAddCmd;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class SysPostAddCmdExe implements CommandExecutorI<Response, SysPostAddCmd> {

    @Override
    public Response execute(SysPostAddCmd cmd) {
        return null;

    }
}
