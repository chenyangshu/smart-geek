package com.smartgeek.component.demo.domain.customer.service.impl;

import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.demo.domain.customer.event.CustomerCreateEvent;
import com.smartgeek.component.demo.domain.customer.event.CustomerUpdateEvent;
import com.smartgeek.component.demo.domain.customer.ports.ICustomerRepositoryPort;
import com.smartgeek.component.demo.domain.customer.service.CustomerDomainService;
import com.smartgeek.component.annotation.domain.DomainService;
import com.smartgeek.component.operation.EntityOperations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author cys
 * @date 2022/11/27 15:59
 * @description:
 */
@Slf4j
@DomainService
@RequiredArgsConstructor
public class CustomerDomainServiceImpl implements CustomerDomainService {
    private final ICustomerRepositoryPort customerRepositoryPort;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void create(Customer customer) {
        EntityOperations.doCreate(customerRepositoryPort)
                .create(() -> customer)
                .update(entity -> entity.init())
                .successHook(entity -> eventPublisher.publishEvent(new CustomerCreateEvent(entity)))
                .execute();
    }

    @Override
    public void valid(Customer customer) {
        EntityOperations.doUpdate(customerRepositoryPort)
                .loadById(customer.getCustomerId())
                .update(entity->entity.valid())
                .successHook(entity -> eventPublisher.publishEvent(new CustomerUpdateEvent(entity)))
                .execute();
    }
}
