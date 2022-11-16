package com.smartgeek.component.demo.app.flow.node;

import com.smartgeek.component.flow.annotation.processor.Processor;
import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.work.WorkContext;

@Processor
public class SecondNodeProcessor implements Work<String> {

   @Override
   public void execute(WorkContext<String> flowHandleContext) {

    }

}