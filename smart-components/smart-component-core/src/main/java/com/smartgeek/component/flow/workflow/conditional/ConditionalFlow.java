//package com.smartgeek.component.flow.workflow;
//
//import cn.hutool.core.util.ObjectUtil;
//import com.smartgeek.component.flow.work.NoOpWork;
//import com.smartgeek.component.flow.work.Work;
//import com.smartgeek.component.flow.work.WorkContext;
//
//import java.util.UUID;
//
///**
// * @author cys
// * @date 2022/11/15 15:23
// * @description:
// */
//public class ConditionalFlow extends AbstractWorkFlow {
//
//    private Work initialWorkUnit;
//
//    private WorkSelector workSelector;
//
//
//    public ConditionalFlow(String name, Work initialWorkUnit, WorkSelector workSelector) {
//        super(name);
//        this.initialWorkUnit = initialWorkUnit;
//        this.workSelector = workSelector;
//    }
//
//    public ConditionalFlow(String name) {
//        super(name);
//    }
//
//    @Override
//    public void execute(WorkContext context) {
//        initialWorkUnit.execute(context);
//        Work work = workSelector.getNext(context);
//        if (ObjectUtil.isNotNull(work)) {
//            work.execute(context);
//        }
//    }
//
//
//    public static class Builder {
//
//        private Builder() {
//            // force usage of static method aNewConditionalFlow
//        }
//
//        public static NameStep aNewConditionalFlow() {
//            return new BuildSteps();
//        }
//
//        public interface NameStep extends ExecuteStep {
//            ExecuteStep named(String name);
//        }
//
//        public interface ExecuteStep {
//           ThenStep execute(Work initialWork);
//        }
//
//        public interface ThenStep {
//            BuildStep then(WorkSelector workSelector);
//        }
//
//        public interface BuildStep {
//            ConditionalFlow build();
//        }
//
//        private static class BuildSteps implements NameStep, ExecuteStep, ThenStep, BuildStep {
//
//            private String name;
//            private Work initialWorkUnit;
//            private WorkSelector workSelector;
//
//            BuildSteps() {
//                this.name = UUID.randomUUID().toString();
//                this.initialWorkUnit = new NoOpWork();
//                this.workSelector =new DummyWorkSelector();
//            }
//
//            @Override
//            public ExecuteStep named(String name) {
//                this.name = name;
//                return this;
//            }
//
//            @Override
//            public ThenStep execute(Work initialWork) {
//                 this.initialWorkUnit=initialWork;
//                 return this;
//            }
//
//            @Override
//            public BuildStep then(WorkSelector workSelector) {
//                this.workSelector=workSelector;
//                return this;
//            }
//
//            @Override
//            public ConditionalFlow build() {
//                return new ConditionalFlow(this.name,this.initialWorkUnit,this.workSelector);
//            }
//        }
//    }
//
//
//
//
//}
