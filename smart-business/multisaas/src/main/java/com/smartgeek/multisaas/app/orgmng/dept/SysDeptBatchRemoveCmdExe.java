package com.smartgeek.multisaas.app.orgmng.dept;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class SysDeptBatchRemoveCmdExe implements CommandExecutorI<Response, SysDeptBatchRemoveCmd> {
    public Response execute(SysDeptBatchRemoveCmd cmd) {
        //校验存在子节点时，不能删除节点
        //删除节点
        return null;
    }
}
