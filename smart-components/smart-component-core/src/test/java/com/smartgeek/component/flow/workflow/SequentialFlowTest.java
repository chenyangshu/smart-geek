package com.smartgeek.component.flow.workflow;

import com.smartgeek.component.flow.engine.WorkContext;
import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.workflow.parallel.ParallelFlow;
import com.smartgeek.component.flow.workflow.sequential.SequentialFlow;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cys
 * @date 2022/11/15 11:57
 * @description:
 */
public class SequentialFlowTest {

    @Test
    public void testExecute() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // given
        Work work1 = Mockito.mock(Work.class);
        Work work2 = Mockito.mock(Work.class);
        Work work3 = Mockito.mock(Work.class);
        Work work4 = Mockito.mock(Work.class);
        Work work5 = Mockito.mock(Work.class);

        WorkContext workContext = Mockito.mock(WorkContext.class);
        SequentialFlow sequentialFlow = SequentialFlow.Builder.aNewSequentialFlow()
                .named("testSequentialFlow")
                .execute(work1)
                .then(work2)
                .then(work3)
                .build();


        ParallelFlow testParallelFlow = ParallelFlow.Builder.aNewParallelFlow()
                .named("testParallelFlow")
                .execute(sequentialFlow,work4,work5)
                .with(executorService)
                .build();

        WorkFlowHub.register(testParallelFlow);

        WorkFlowHub.get("testParallelFlow").execute(workContext);
//        WorkFlowRegistrar workFlowRegistrar = new WorkFlowRegistrar();
//        workFlowRegistrar.register(testParallelFlow);

//        AbstractWorkFlow workFlow = workFlowRegistrar.get("testConditionalFlow");
//        testParallelFlow.execute(workContext);


    }

}
