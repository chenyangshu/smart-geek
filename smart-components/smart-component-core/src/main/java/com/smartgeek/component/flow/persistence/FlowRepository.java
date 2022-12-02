package com.smartgeek.component.flow.persistence;

import java.util.concurrent.Future;

/**
 * @author cys
 * @date 2022/9/21 13:21
 * @description:
 */
public interface FlowRepository {
    boolean isEnabled();

    Long addFailedRecord(FlowExeRecord record);

    Future<Long> asynAddFailedRecord(FlowExeRecord record);

    Long addSuccessfulRecord(FlowExeRecord record);

    Future<Long> asynAddSuccessfulRecord(FlowExeRecord record);
}
