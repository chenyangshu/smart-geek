package com.smartgeek.component.demo.app.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.QueryExecutorI;
import com.smartgeek.component.demo.app.ports.CustomerQueryPort;
import com.smartgeek.component.demo.client.dto.CustomerCO;
import com.smartgeek.component.demo.client.dto.query.CustomerListByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cys
 * @date 2022/11/27 16:54
 * @description:
 */
@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class CustomerListByNameQryExe implements QueryExecutorI<MultiResponse<CustomerCO>, CustomerListByNameQry> {
    private final CustomerQueryPort customerQueryPort;

    @Override
    public MultiResponse<CustomerCO> execute(CustomerListByNameQry cmd) {
        return MultiResponse.of(customerQueryPort.findListBy(cmd));
    }
}
