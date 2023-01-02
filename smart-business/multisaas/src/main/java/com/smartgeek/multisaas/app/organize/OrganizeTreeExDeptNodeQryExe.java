package com.smartgeek.multisaas.app.organize;

import com.alibaba.cola.dto.MultiResponse;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.QueryExecutorWithoutInputI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class OrganizeTreeExDeptNodeQryExe implements QueryExecutorWithoutInputI<MultiResponse<SysOrganizeTreeCo>> {

    @Override
    public MultiResponse<SysOrganizeTreeCo> execute() {
        return null;

    }
}
