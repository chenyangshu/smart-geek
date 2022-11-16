package com.smartgeek.component.flow.workflow.parallel;

import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.work.WorkContext;
import com.smartgeek.component.flow.workflow.AbstractWorkFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/**
 * @author cys
 * @date 2022/11/15 13:56
 * @description:
 */
public class ParallelFlow extends AbstractWorkFlow {
    private final List<Work> workUnits = new ArrayList<>();
    private final ParallelFlowExecutor workExecutor;

    ParallelFlow(String name, List<Work> workUnits, ParallelFlowExecutor parallelFlowExecutor) {
        super(name);
        this.workUnits.addAll(workUnits);
        this.workExecutor = parallelFlowExecutor;
    }

    @Override
    public void execute(WorkContext workContext) {
        workExecutor.execute(workUnits, workContext);
    }

    public static class Builder {

        private Builder() {
            // force usage of method aNewParallelFlow
        }

        public static NameStep aNewParallelFlow() {
            return new BuildSteps();
        }

        public interface NameStep extends ExecuteStep {
            ExecuteStep named(String name);

            NameStep isEnableFlowTx(boolean flag);

            NameStep txManager(String txManager);

        }

        public interface ExecuteStep {
            WithStep execute(Work... workUnits);
        }

        public interface WithStep {
            /**
             * A {@link ParallelFlow} requires an {@link ExecutorService} to
             * execute work units in parallel using multiple threads.
             *
             * <strong>It is the responsibility of the caller to manage the lifecycle
             * of the executor service.</strong>
             *
             * @param executorService to use to execute work units in parallel
             * @return the builder instance
             */
            BuildStep with(ExecutorService executorService);
        }

        public interface BuildStep {
            ParallelFlow build();
        }

        private static class BuildSteps implements NameStep, ExecuteStep, WithStep, BuildStep {

            private String name;

            private boolean enableFlowTx = true;
            private String txManager = "";
            private final List<Work> works;
            private ExecutorService executorService;

            public BuildSteps() {
                this.name = UUID.randomUUID().toString();
                this.works = new ArrayList<>();
            }

            @Override
            public ExecuteStep named(String name) {
                this.name = name;
                return this;
            }

            @Override
            public NameStep isEnableFlowTx(boolean flag) {
                this.enableFlowTx = flag;
                return this;
            }

            @Override
            public NameStep txManager(String txManager) {
                this.txManager = txManager;
                return this;
            }

            @Override
            public WithStep execute(Work... workUnits) {
                this.works.addAll(Arrays.asList(workUnits));
                return this;
            }

            @Override
            public BuildStep with(ExecutorService executorService) {
                this.executorService = executorService;
                return this;
            }

            @Override
            public ParallelFlow build() {
                ParallelFlow parallelFlow = new ParallelFlow(
                        this.name, this.works,
                        new ParallelFlowExecutor(this.name, this.enableFlowTx, this.executorService));
                parallelFlow.setEnableFlowTx(this.enableFlowTx);
                parallelFlow.setTxManager(this.txManager);
                return parallelFlow;
            }
        }

    }


}
