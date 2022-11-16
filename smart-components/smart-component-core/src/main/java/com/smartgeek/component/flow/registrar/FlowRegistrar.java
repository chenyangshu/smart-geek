package com.smartgeek.component.flow.registrar;

import com.smartgeek.component.flow.workflow.AbstractWorkFlow;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author cys
 * @date 2022/11/15 11:41
 * @description:
 */
@Component
public class FlowRegistrar  extends AbstractRegistrar<String, AbstractWorkFlow> {
    public FlowRegistrar() {
        super(AbstractWorkFlow::getName);
    }

}
