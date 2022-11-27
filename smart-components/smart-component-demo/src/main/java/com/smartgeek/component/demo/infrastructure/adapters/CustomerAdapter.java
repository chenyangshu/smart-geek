package com.smartgeek.component.demo.infrastructure.adapters;

import com.smartgeek.component.annotation.infrastructure.Adapter;
import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.demo.domain.customer.ports.CustomerPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author cys
 * @date 2022/11/27 16:30
 * @description:
 */
@Adapter
public class CustomerAdapter implements CustomerPort{
    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public <S extends Customer> S create(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> create(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Customer> S updateById(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> updateById(Iterable<S> entities) {
        return null;
    }
}
