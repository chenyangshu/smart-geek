package com.smartgeek.component.demo.app.command;

import com.alibaba.cola.dto.SingleResponse;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.CommandExecutorI;
import com.smartgeek.component.demo.app.converter.CustomerClientConverter;
import com.smartgeek.component.demo.client.dto.CustomerAddCmd;
import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.demo.domain.customer.service.CustomerDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class CustomerAddCmdExe implements CommandExecutorI<SingleResponse<String>, CustomerAddCmd> {


    private final CustomerClientConverter customerClientConverter;
    private final CustomerDomainService customerDomainService;

    @Override
    public SingleResponse<String> execute(CustomerAddCmd cmd) {
        //1.做一些check，此处省略
        Customer customer = customerClientConverter.sourceToTarget(cmd);
        customerDomainService.create(customer);
        return SingleResponse.of(customer.getName());
    }

}