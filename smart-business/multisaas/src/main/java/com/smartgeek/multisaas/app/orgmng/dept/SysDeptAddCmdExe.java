package com.smartgeek.multisaas.app.orgmng.dept;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class SysDeptAddCmdExe implements CommandExecutorI<Response, SysDeptAddCmd> {

    @Override
    public Response execute(SysDeptAddCmd cmd) {
        //校验父级停用时，不能启用自己
        //添加部门
        return null;

    }
}
