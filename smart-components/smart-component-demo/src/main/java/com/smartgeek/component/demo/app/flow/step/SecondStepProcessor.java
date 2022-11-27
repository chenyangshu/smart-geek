package com.smartgeek.component.demo.app.flow.step;

import com.smartgeek.component.flow.annotation.processor.Processor;
import com.smartgeek.component.flow.engine.WorkContext;
import com.smartgeek.component.flow.work.Work;

@Processor
public class SecondStepProcessor implements Work<String> {

    @Override
    public void execute(WorkContext<String> flowHandleContext) {

    }

}