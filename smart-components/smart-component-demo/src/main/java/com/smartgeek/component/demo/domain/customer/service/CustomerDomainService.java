package com.smartgeek.component.demo.domain.customer.service;

import com.smartgeek.component.demo.domain.customer.Customer;

/**
 * @author cys
 * @date 2022/11/27 15:58
 * @description:
 */
public interface CustomerDomainService {
    void create(Customer customer);
    void valid(Customer customer);
}
