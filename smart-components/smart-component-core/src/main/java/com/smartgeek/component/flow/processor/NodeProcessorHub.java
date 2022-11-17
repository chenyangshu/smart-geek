package com.smartgeek.component.flow.processor;

import com.smartgeek.component.flow.annotation.processor.Processor;
import com.smartgeek.component.flow.exception.FlowErrorCode;
import com.smartgeek.component.flow.exception.FlowException;
import com.smartgeek.component.flow.work.Work;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cys
 * @date 2022/11/16 15:56
 * @description:
 */
@Component
@RequiredArgsConstructor
public class NodeProcessorHub {
    private final ApplicationContext applicationContext;

    /**
     * 处理器执行程序映射
     */
    private Map<String, ProcessorExecutor> processorExecutorMap = new ConcurrentHashMap();


    @PostConstruct
    public void init() {
        String[] processorBeanNames = this.applicationContext.getBeanNamesForAnnotation(Processor.class);
        for (String processorBeanName : processorBeanNames) {
            NodeProcessor nodeProcessor = this.getProcessorByBeanName(processorBeanName);
            ProcessorExecutor processorExecutor = ProcessorParser.parseProcessor(nodeProcessor);
            if (this.processorExecutorMap.containsKey(processorExecutor.getProcessorName())) {
                throw new FlowException(FlowErrorCode.NODE_PROCESSOR_DUPLICATE_NAME.getErrCode(), "存在重名的处理器：" + processorExecutor.getProcessorName());
            }
            this.processorExecutorMap.put(processorExecutor.getProcessorName(), processorExecutor);
        }
    }


    /**
     * 获取处理器通过bean名称
     *
     * @param beanName bean名字
     * @return {@link Work}
     */
    protected NodeProcessor getProcessorByBeanName(String beanName) {
        Object processor = this.applicationContext.getBean(beanName);
        this.checkNodeProcessor(processor);
        return (NodeProcessor) processor;
    }


    /**
     * 检查节点处理器
     *
     * @param processor 处理器
     */
    protected void checkNodeProcessor(Object processor) {
        //是否实现NodeProcessor
        if (!(processor instanceof Work)) {
            throw new FlowException(FlowErrorCode.NODE_PROCESSOR_NOT_IMPLEMENT_INTERFACE.getErrCode(), "[Flow-Engine] 流程节点处理器" + processor.getClass().getName() + "没有实现处理器接口" + Work.class.getName());
        }
    }


    /**
     * 得到所需处理器执行程序
     *
     * @param processor 处理器
     * @return {@link ProcessorExecutor}
     */
    public ProcessorExecutor getRequiredProcessorExecutor(String processor) {
        if (!this.processorExecutorMap.containsKey(processor)) {
            throw new IllegalArgumentException("不存在处理器：" + processor);
        } else {
            return (ProcessorExecutor) this.processorExecutorMap.get(processor);
        }
    }


}
