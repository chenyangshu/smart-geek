package com.smartgeek.component.flow.workflow.sequential;

import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.engine.WorkContext;
import com.smartgeek.component.flow.workflow.AbstractWorkFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author cys
 * @date 2022/11/15 10:32
 * @description:
 */
public class SequentialFlow extends AbstractWorkFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(SequentialFlow.class.getName());

    private final List<Work> workUnits = new ArrayList<>();
    private final SequentialFlowExecutor sequentialFlowExecutor;

    public SequentialFlow(String name, List<Work> workUnits, SequentialFlowExecutor executor) {
        super(name);
        this.workUnits.addAll(workUnits);
        this.sequentialFlowExecutor = executor;
    }

    /**
     * {@inheritDoc}
     */
    public void execute(WorkContext workContext) {
        sequentialFlowExecutor.execute(workUnits, workContext);
    }

    public static class Builder {

        private Builder() {
            // force usage of static method aNewSequentialFlow
        }

        public static NameStep aNewSequentialFlow() {
            return new BuildSteps();
        }

        public interface NameStep extends ExecuteStep {
            ExecuteStep named(String name);

            NameStep isEnableFlowTx(boolean flag);

            NameStep txManager(String txManager);

        }


        public interface ExecuteStep {
            ThenStep execute(Work initialWork);

            ThenStep execute(List<Work> initialWorkUnits);
        }

        public interface ThenStep {
            ThenStep then(Work nextWork);

            ThenStep then(List<Work> nextWorkUnits);

            ThenStep thenTx(Work nextWork);

            ThenStep thenTx(List<Work> nextWorkUnits);


            SequentialFlow build();
        }

        private static class BuildSteps implements NameStep, ExecuteStep, ThenStep {

            private String name;
            private final List<Work> works;

            private boolean enableFlowTx;
            private String txManager="";

            private List<Class<? extends Work>> enableTxWorks;


            BuildSteps() {
                this.name = UUID.randomUUID().toString();
                this.works = new ArrayList<>();
                this.enableTxWorks = new ArrayList<>();

            }

            public ExecuteStep named(String name) {
                this.name = name;
                return this;
            }

            @Override
            public NameStep isEnableFlowTx(boolean enableFlowTx) {
                this.enableFlowTx = enableFlowTx;
                return this;
            }

            @Override
            public NameStep txManager(String txManager) {
                this.txManager = txManager;
                return this;
            }


            @Override
            public ThenStep execute(Work initialWork) {
                this.works.add(initialWork);
                return this;
            }

            @Override
            public ThenStep execute(List<Work> initialWorkUnits) {
                this.works.addAll(initialWorkUnits);
                return this;
            }

            @Override
            public ThenStep then(Work nextWork) {
                this.works.add(nextWork);
                return this;
            }

            @Override
            public ThenStep then(List<Work> nextWorkUnits) {
                this.works.addAll(nextWorkUnits);
                return this;
            }

            @Override
            public ThenStep thenTx(Work nextWork) {
                this.works.add(nextWork);
                this.enableTxWorks.add(nextWork.getClass());
                return this;
            }

            @Override
            public ThenStep thenTx(List<Work> nextWorkUnits) {
                this.works.addAll(nextWorkUnits);
                nextWorkUnits.stream().forEach(work -> this.enableTxWorks.add(work.getClass()));
                return this;
            }

            @Override
            public SequentialFlow build() {
                SequentialFlow sequentialFlow = new SequentialFlow(this.name, this.works, new SequentialFlowExecutor(this.enableFlowTx, this.name, this.enableTxWorks));
                sequentialFlow.setEnableFlowTx(this.enableFlowTx);
                sequentialFlow.setTxManager(this.txManager);
                return sequentialFlow;
            }
        }
    }


}
