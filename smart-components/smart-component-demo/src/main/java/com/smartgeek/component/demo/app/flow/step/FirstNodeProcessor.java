package com.smartgeek.component.demo.app.flow.step;

import com.smartgeek.component.flow.annotation.processor.Processor;
import com.smartgeek.component.flow.engine.FlowHandleContext;
import com.smartgeek.component.flow.processor.NodeProcessor;

/**
 * @author cys
 */
@Processor
public class FirstNodeProcessor implements NodeProcessor<String,Boolean> {

    @Override
    public Boolean execute(FlowHandleContext<String> flowHandleContext) {
        return true;
    }
}
