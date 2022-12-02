package com.smartgeek.component.flow;

import com.smartgeek.component.flow.persistence.FlowExeRecord;
import com.smartgeek.component.flow.persistence.FlowPersistenceProperties;
import com.smartgeek.component.flow.persistence.FlowRepository;

import java.util.concurrent.Future;

/**
 * @author cys
 * @date 2022/9/21 17:11
 * @description:
 */
public class DummyFlowRepository implements FlowRepository {

    private FlowPersistenceProperties properties;


    public DummyFlowRepository(FlowPersistenceProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean isEnabled() {
        return this.properties.isPersistence();
    }

    @Override
    public Long addFailedRecord(FlowExeRecord record) {
        return null;
    }

    @Override
    public Future<Long> asynAddFailedRecord(FlowExeRecord record) {
        return null;
    }

    @Override
    public Long addSuccessfulRecord(FlowExeRecord record) {
        return null;
    }

    @Override
    public Future<Long> asynAddSuccessfulRecord(FlowExeRecord record) {
        return null;
    }
}
