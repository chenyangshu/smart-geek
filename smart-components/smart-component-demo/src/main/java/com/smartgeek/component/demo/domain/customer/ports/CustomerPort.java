package com.smartgeek.component.demo.domain.customer.ports;

import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.operation.CrudPort;

/**
 * @author cys
 * @date 2022/11/27 16:01
 * @description:
 */
public interface CustomerPort extends CrudPort<Customer,Long> {
}
