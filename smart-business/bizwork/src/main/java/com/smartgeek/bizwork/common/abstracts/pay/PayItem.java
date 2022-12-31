package com.smartgeek.bizwork.common.abstracts.pay;

import java.math.BigDecimal;

public interface PayItem {

  BigDecimal getMoney();

  PayGroup getPayGroup();

  PayType getPayType();

}