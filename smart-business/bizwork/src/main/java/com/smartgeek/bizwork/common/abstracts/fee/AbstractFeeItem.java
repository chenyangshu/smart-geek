package com.smartgeek.bizwork.common.abstracts.fee;

import java.math.BigDecimal;

public class AbstractFeeItem<O> implements FeeItem<O>{

    private final O orderInfo;

    private final FeeItemType itemType;

    private final BigDecimal itemMoney;

    public AbstractFeeItem(O orderInfo, FeeItemType itemType, BigDecimal itemMoney) {
        this.orderInfo = orderInfo;
        this.itemType = itemType;
        this.itemMoney = itemMoney;
    }

    @Override
    public BigDecimal getFeeItemOriginMoney() {
        return itemMoney;
    }

    @Override
    public FeeItemType getFeeItemType() {
        return itemType;
    }

    @Override
    public O getOrderInfo() {
        return orderInfo;
    }
}

