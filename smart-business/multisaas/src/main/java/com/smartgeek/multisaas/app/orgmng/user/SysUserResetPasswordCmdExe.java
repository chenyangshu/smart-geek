package com.smartgeek.multisaas.app.orgmng.user;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.multisaas.app.orgmng.user.SysUserResetPasswordCmd;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class SysUserResetPasswordCmdExe {
    public Response execute(SysUserResetPasswordCmd cmd) {
        return null;

    }
}
