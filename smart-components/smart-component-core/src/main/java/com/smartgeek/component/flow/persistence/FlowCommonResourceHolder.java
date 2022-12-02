package com.smartgeek.component.flow.persistence;

import java.util.Optional;

/**
 * @author cys
 * @date 2022/9/21 13:21
 * @description:
 */
public class FlowCommonResourceHolder {
    private FlowRepository flowRepository;
    private static final FlowCommonResourceHolder INSTANCE = new FlowCommonResourceHolder();

    private FlowCommonResourceHolder() {
    }

    public static void setFlowRepository(FlowRepository flowRepository) {
        INSTANCE.flowRepository = flowRepository;
    }

    public static FlowRepository getFlowRepository() {
        return INSTANCE.flowRepository;
    }

    public static boolean isFlowRepositoryEnabled() {
        return (Boolean) Optional.ofNullable(INSTANCE.flowRepository).map(FlowRepository::isEnabled).orElse(false);
    }
}
