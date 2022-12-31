package com.smartgeek.bizwork.common.abstracts.pay;

import com.smartgeek.bizwork.common.core.annotation.FieldDesc;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CoinPayItem extends AbstractPayItem{

  public CoinPayItem(BigDecimal money) {
    super(money, PayType.COIN, PayGroup.VIRTUAL_PROPERTY);
  }

  @FieldDesc(name = "来源")
  private String source;
  

}