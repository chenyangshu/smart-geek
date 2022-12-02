package com.smartgeek.component.demo.app.flow.node;

import com.smartgeek.component.flow.annotation.processor.Processor;
import com.smartgeek.component.flow.engine.FlowHandleContext;
import com.smartgeek.component.flow.processor.NodeProcessor;

/**
 * @author cys
 */
@Processor
public class SecondNodeProcessor implements NodeProcessor<String,Boolean> {

    @Override
    public Boolean execute(FlowHandleContext<String> flowHandleContext) {
        return true;
    }
}
