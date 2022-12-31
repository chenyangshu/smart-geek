package com.smartgeek.component.demo.domain.customer.ports;

import com.smartgeek.component.annotation.domain.Port;
import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.operation.BaseRepository;

/**
 * @author cys
 * @date 2022/11/27 16:01
 * @description:
 */
@Port
public interface ICustomerRepositoryPort extends BaseRepository<Customer> {
}
