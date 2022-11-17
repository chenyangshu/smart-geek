package com.smartgeek.component.flow.work;

import com.smartgeek.component.flow.engine.WorkContext;

/**
 * @author cys
 * @date 2022/11/15 10:20
 * @description:
 */
public interface Work<T> {

    default String getName() {
        return this.getClass().getName();
    }

    void execute(WorkContext<T> workContext);

}
