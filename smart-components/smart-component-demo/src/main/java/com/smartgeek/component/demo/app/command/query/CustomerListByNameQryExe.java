package com.smartgeek.component.demo.app.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.smartgeek.component.annotation.command.CmdHandler;
import com.smartgeek.component.command.QueryExecutorI;
import com.smartgeek.component.demo.client.dto.clientobject.CustomerCO;
import com.smartgeek.component.demo.client.dto.query.CustomerListByNameQry;
import com.smartgeek.component.demo.infrastructure.converter.CustomerConverter;
import com.smartgeek.component.demo.infrastructure.tunnel.db.dao.CustomerMapper;
import com.smartgeek.component.demo.infrastructure.tunnel.db.po.CustomerPO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

/**
 * @author cys
 * @date 2022/11/27 16:54
 * @description:
 */
@Slf4j
@CmdHandler
@RequiredArgsConstructor
public class CustomerListByNameQryExe implements QueryExecutorI<MultiResponse<CustomerCO>, CustomerListByNameQry> {

    private final CustomerMapper customerMapper;
    private final CustomerConverter customerConverter;

    @Override
    public MultiResponse<CustomerCO> execute(CustomerListByNameQry cmd) {
        return MultiResponse.of(customerMapper.selectList(new LambdaQueryWrapper<>(CustomerPO.class)
                        .eq(CustomerPO::getCompanyName, cmd.getCompanyName())
                ).stream()
                .map(customerPO -> customerConverter.persistenceToClient(customerPO))
                .collect(Collectors.toList()));
    }
}
