package com.smartgeek.component.flow;

import com.smartgeek.component.flow.persistence.FlowCommonResourceHolder;
import com.smartgeek.component.flow.persistence.FlowRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 默认流公共资源持有者自动配置
 *
 * @author cys
 * @date 2022/9/21 15:44
 * @description:
 */
@Configuration
public class SmartFlowCommonResourceHolderAutoConfiguration implements InitializingBean {

    @Autowired(required = false)
    private FlowRepository flowRepository;

    public SmartFlowCommonResourceHolderAutoConfiguration() {
    }

    public void afterPropertiesSet() throws Exception {
        FlowCommonResourceHolder.setFlowRepository(this.flowRepository);
    }

}
