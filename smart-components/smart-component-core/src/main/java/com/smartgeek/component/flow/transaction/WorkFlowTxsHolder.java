package com.smartgeek.component.flow.transaction;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.smartgeek.component.flow.workflow.WorkFlowHub;
import com.smartgeek.component.flow.workflow.AbstractWorkFlow;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cys
 * @date 2022/11/16 10:20
 * @description:
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WorkFlowTxsHolder {
    private final ApplicationContext applicationContext;

    private final PlatformTransactionManager transactionManager;

    // 流程注册器
//    private final WorkFlowRegistrar workFlowRegistrar;

    private Map<String, FlowTxExecutor> flowTxExecutorMap = new ConcurrentHashMap<>();


    @PostConstruct
    public void init() {
        Set<String> flowNames = WorkFlowHub.getNames();
        if (CollectionUtil.isEmpty(flowNames)) {
            return;
        }

        for (String flowName : flowNames) {
            AbstractWorkFlow workFlow = WorkFlowHub.get(flowName);
            if (workFlow.getEnableFlowTx()) {
                FlowTxExecutor flowTxExecutor = WorkFlowTxParser.parseFlowTx(flowName, this.getTxManager(flowName, workFlow.getTxManager()));
                this.flowTxExecutorMap.put(flowName, flowTxExecutor);
            }
        }

    }


    /**
     * 得到tx经理
     *
     * @param flowName          流名字
     * @param txManagerBeanName tx manager bean名称
     * @return {@link PlatformTransactionManager}
     */
    protected PlatformTransactionManager getTxManager(String flowName, String txManagerBeanName) {
        PlatformTransactionManager txManager = null;

        if (StrUtil.isEmpty(txManagerBeanName)) {
            txManager = this.transactionManager;
        } else {
            txManager = Try.of(() -> (PlatformTransactionManager) this.applicationContext.getBean(txManagerBeanName)).onFailure(NoSuchBeanDefinitionException.class, e -> new IllegalArgumentException("流程" + flowName + ": 不存名称为" + txManagerBeanName + "的事务管理器"))
                    .onFailure(ClassCastException.class, e -> new IllegalArgumentException("流程" + flowName + ": 名称为" + txManagerBeanName + "的bean，类型不是PlatformTransactionManager"))
                    .onFailure(Exception.class, e -> new IllegalArgumentException("流程" + flowName + ": 请检查事务管理器" + txManagerBeanName + "是否正常配置"))
                    .getOrNull();
        }

        Assert.notNull(txManager, "流程" + flowName + ": 开启了流程事务，但没有找到事务管理器，请检查配置");
        return txManager;

    }


    public Set<String> getFlowNames() {
        return this.flowTxExecutorMap.keySet();
    }

    public FlowTxExecutor getRequiredFlowTxExecutor(String flow) {
        if (!this.flowTxExecutorMap.containsKey(flow)) {
            throw new IllegalArgumentException("不存在流程" + flow + "的流程事务");
        } else {
            return (FlowTxExecutor) this.flowTxExecutorMap.get(flow);
        }
    }


}
