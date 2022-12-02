package com.smartgeek.component.demo.app.command;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorI;
import com.smartgeek.component.demo.app.context.OnSaleContext;
import com.smartgeek.component.demo.app.service.phase.OnSaleContextInitPhase;
import com.smartgeek.component.demo.app.service.phase.OnSaleDataCheckPhase;
import com.smartgeek.component.demo.app.service.phase.OnSaleProcessPhase;
import com.smartgeek.component.demo.client.dto.OnSaleNormalItemCmd;

import javax.annotation.Resource;

/**
 * @author cys
 */
@CmdHandler
public class OnSaleCommandExe implements CommandExecutorI<Response, OnSaleNormalItemCmd> {

    @Resource
    private OnSaleContextInitPhase onSaleContextInitPhase;
    @Resource
    private OnSaleDataCheckPhase onSaleDataCheckPhase;
    @Resource
    private OnSaleProcessPhase onSaleProcessPhase;


    @Override
    public Response execute(OnSaleNormalItemCmd cmd) {
        OnSaleContext onSaleContext = init(cmd);

        checkData(onSaleContext);

        process(onSaleContext);

        return Response.buildSuccess();
    }

    private OnSaleContext init(OnSaleNormalItemCmd cmd) {
        return onSaleContextInitPhase.init(cmd);
    }

    private void checkData(OnSaleContext onSaleContext) {
        onSaleDataCheckPhase.check(onSaleContext);
    }

    private void process(OnSaleContext onSaleContext) {
        onSaleProcessPhase.process(onSaleContext);
    }


}
