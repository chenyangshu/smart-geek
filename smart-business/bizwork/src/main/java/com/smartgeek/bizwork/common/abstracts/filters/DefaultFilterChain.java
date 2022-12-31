package com.smartgeek.bizwork.common.abstracts.filters;

import com.smartgeek.bizwork.common.abstracts.model.OrderContext;

import java.util.Objects;

public class DefaultFilterChain<T extends OrderContext> implements OrderFilterChain<T> {

    private OrderFilterChain<T> next;
    private OrderFilter<T> filter;

    public DefaultFilterChain(OrderFilterChain chain, OrderFilter filter) {
        this.next = chain;
        this.filter = filter;
    }

    @Override
    public void handle(T context) {
        filter.doFilter(context, this);
    }

    @Override
    public void fireNext(T ctx) {
        OrderFilterChain nextChain = this.next;
        if (Objects.nonNull(nextChain)) {
            nextChain.handle(ctx);
        }
    }
}