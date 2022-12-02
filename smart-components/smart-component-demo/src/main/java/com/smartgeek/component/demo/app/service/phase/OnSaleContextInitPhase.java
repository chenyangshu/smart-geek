package com.smartgeek.component.demo.app.service.phase;

import com.smartgeek.component.annotation.app.Phase;
import com.smartgeek.component.demo.app.context.OnSaleContext;
import com.smartgeek.component.demo.client.dto.OnSaleNormalItemCmd;

/**
 * @author cys
 */
@Phase
public class OnSaleContextInitPhase {
    public OnSaleContext init(OnSaleNormalItemCmd cmd) {
        return null;
    }
}
