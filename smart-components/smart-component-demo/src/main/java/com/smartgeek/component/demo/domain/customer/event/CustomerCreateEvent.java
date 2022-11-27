package com.smartgeek.component.demo.domain.customer.event;

import com.smartgeek.component.demo.domain.customer.Customer;
import lombok.Value;

/**
 * @author cys
 * @date 2022/11/27 16:13
 * @description:
 */
@Value
public class CustomerCreateEvent {
    private Customer customer;
}
