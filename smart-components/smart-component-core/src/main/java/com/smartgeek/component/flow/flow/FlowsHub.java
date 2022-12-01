package com.smartgeek.component.flow.flow;

import com.smartgeek.component.flow.annotation.flow.Flow;
import com.smartgeek.component.flow.processor.NodeProcessorHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cys
 * @date 2022/9/21 10:56
 * @description:
 */
@Component
public class FlowsHub {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private NodeProcessorHub nodeProcessorHub;

    private Map<String, FlowExecutor> flowExecutorMap = new ConcurrentHashMap();


    public FlowsHub() {
    }

    @PostConstruct
    public void init() {
        String[] flowBeanNames = this.applicationContext.getBeanNamesForAnnotation(Flow.class);

        for (String flowBeanName : flowBeanNames) {
            FlowExecutor flowExecutor = FlowParser.parseFlow(this.applicationContext.getBean(flowBeanName), this.nodeProcessorHub);
            if (this.flowExecutorMap.containsKey(flowExecutor.getFlowName())) {
                throw new RuntimeException("存在重名的流程" + flowExecutor.getFlowName());
            }

            this.flowExecutorMap.put(flowExecutor.getFlowName(), flowExecutor);
        }

    }


    public Set<String> getFlowNames() {
        return this.flowExecutorMap.keySet();
    }

    public FlowExecutor getRequiredFlowExecutor(String flow) {
        if (!this.flowExecutorMap.containsKey(flow)) {
            throw new IllegalArgumentException("不存在流程" + flow);
        } else {
            return (FlowExecutor) this.flowExecutorMap.get(flow);
        }
    }

    public Map<String, FlowExecutor> getFlowExecutorMap() {
        return this.flowExecutorMap;
    }

    public void setFlowExecutorMap(Map<String, FlowExecutor> flowExecutorMap) {
        this.flowExecutorMap = flowExecutorMap;
    }


}
