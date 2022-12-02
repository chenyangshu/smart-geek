package com.smartgeek.component.demo.app.command;

import com.alibaba.cola.dto.SingleResponse;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorWithoutInputI;
import com.smartgeek.component.flow.FlowEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cys
 */
@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class TestFlowCmdExe implements CommandExecutorWithoutInputI<SingleResponse<String>> {

    private final FlowEngine flowEngine;

    @Override
    public SingleResponse<String> execute() {
        flowEngine.start("demoFlow", "张三");
        return SingleResponse.of("success");
    }
}
