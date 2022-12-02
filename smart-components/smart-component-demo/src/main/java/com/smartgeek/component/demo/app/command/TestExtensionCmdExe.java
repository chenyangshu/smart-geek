package com.smartgeek.component.demo.app.command;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorWithoutInputI;
import com.smartgeek.component.demo.app.extension.IPayExtPt;
import com.smartgeek.component.demo.client.constant.Constants;
import com.smartgeek.component.flow.FlowEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author cys
 */
@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class TestExtensionCmdExe implements CommandExecutorWithoutInputI<SingleResponse<String>> {
    private final ExtensionExecutor extensionExecutor;

    @Override
    public SingleResponse<String> execute() {
        BizScenario bizScenario = BizScenario.valueOf(Constants.BIZ_DEMO, Constants.USE_CASE_PAYMENT, Constants.SCENARIO_ALI_PAYMENT);
        Boolean result = extensionExecutor.execute(IPayExtPt.class, bizScenario, payExtPt -> payExtPt.pay());
        return SingleResponse.of("success");
    }
}
