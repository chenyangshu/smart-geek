package com.smartgeek.multisaas.app.orgmng.dept;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class SysDeptEditCmdExe  implements CommandExecutorI<Response, SysDeptEditCmd> {
    public Response execute(SysDeptEditCmd cmd) {
        //校验上级不能是自己
        //校验上级不能是自己的子节点
        //校验父级停用时，不能启用自己
        //校验存在未停用的子节点，不能禁用自己
        return null;
    }
}
