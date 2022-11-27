package com.smartgeek.component.demo.infrastructure.adapters;

import com.smartgeek.component.annotation.infrastructure.Adapter;
import com.smartgeek.component.demo.app.ports.CustomerQueryPort;
import com.smartgeek.component.demo.client.dto.CustomerCO;
import com.smartgeek.component.demo.client.dto.query.CustomerListByNameQry;

import java.util.Collection;

/**
 * @author cys
 * @date 2022/11/27 21:03
 * @description:
 */
@Adapter
public class CustomerQueryAdapter implements CustomerQueryPort {
    @Override
    public Collection<CustomerCO> findListBy(CustomerListByNameQry cmd) {
        return null;
    }
}
