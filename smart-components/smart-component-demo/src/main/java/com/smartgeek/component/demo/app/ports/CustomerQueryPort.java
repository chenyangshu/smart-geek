package com.smartgeek.component.demo.app.ports;

import com.smartgeek.component.demo.client.dto.CustomerCO;
import com.smartgeek.component.demo.client.dto.query.CustomerListByNameQry;

import java.util.Collection;

/**
 * @author cys
 * @date 2022/11/27 20:59
 * @description:
 */
public interface CustomerQueryPort {

    Collection<CustomerCO> findListBy(CustomerListByNameQry cmd);
}
