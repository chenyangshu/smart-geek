package com.smartgeek.component.demo.app.flow.step;

import com.smartgeek.component.flow.annotation.processor.Processor;
import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.engine.WorkContext;

@Processor
public class FirstStepProcessor implements Work<String> {

   @Override
   public void execute(WorkContext<String> flowHandleContext) {

    }

}