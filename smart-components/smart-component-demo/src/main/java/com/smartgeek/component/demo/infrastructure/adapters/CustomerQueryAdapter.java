package com.smartgeek.component.demo.infrastructure.adapters;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.smartgeek.component.annotation.infrastructure.Adapter;
import com.smartgeek.component.demo.app.ports.CustomerQueryPort;
import com.smartgeek.component.demo.client.dto.CustomerCO;
import com.smartgeek.component.demo.client.dto.query.CustomerListByNameQry;
import com.smartgeek.component.demo.infrastructure.converter.CustomerConverter;
import com.smartgeek.component.demo.infrastructure.tunnel.db.dao.CustomerMapper;
import com.smartgeek.component.demo.infrastructure.tunnel.db.po.CustomerPO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cys
 * @date 2022/11/27 21:03
 * @description:
 */
@Adapter
public class CustomerQueryAdapter implements CustomerQueryPort {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public Collection<CustomerCO> findListBy(CustomerListByNameQry cmd) {
        return customerMapper.selectList(new LambdaQueryWrapper<>(CustomerPO.class)
                .eq(CustomerPO::getCompanyName, cmd.getCompanyName())
        ).stream().map(customerPO -> customerConverter.persistenceToClient(customerPO)).collect(Collectors.toList());
    }
}
