package com.smartgeek.component.demo.app.extension;

import com.alibaba.cola.extension.Extension;
import com.smartgeek.component.demo.client.constant.Constants;

/**
 * @author cys
 */
@Extension(bizId = Constants.BIZ_DEMO,useCase = Constants.USE_CASE_PAYMENT,scenario =  Constants.SCENARIO_ALI_PAYMENT)
public class AliPayExt implements IPayExtPt {
    @Override
    public boolean pay() {
        return true;
    }
}
