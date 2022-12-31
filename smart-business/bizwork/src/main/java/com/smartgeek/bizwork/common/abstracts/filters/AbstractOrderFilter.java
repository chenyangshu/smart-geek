package com.smartgeek.bizwork.common.abstracts.filters;

import com.smartgeek.bizwork.common.abstracts.model.OrderContext;

public abstract class AbstractOrderFilter<T extends OrderContext> implements OrderFilter<T> {

  @Override
  public void doFilter(T context, OrderFilterChain chain) {
    if (context.getFilterSelector().matchFilter(this.getClass().getSimpleName())) {
      handle(context);
    }
    if (context.continueChain()) {
      chain.fireNext(context);
    }
  }

  protected abstract void handle(T context);
}