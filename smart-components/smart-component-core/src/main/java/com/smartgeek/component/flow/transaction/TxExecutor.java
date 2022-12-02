package com.smartgeek.component.flow.transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author cys
 * @date 2022/9/21 12:48
 * @description:
 */
public class TxExecutor {

    private static final TransactionDefinition TX_DEFINITION = new DefaultTransactionDefinition(3);
    private PlatformTransactionManager transactionManager;
    private ThreadLocal<TransactionStatus> txStatusHolder = new ThreadLocal();


    public TxExecutor(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void createTx() {
        if (this.txStatusHolder.get() != null) {
            throw new IllegalStateException("本线程事务已存在，不能同时创建多个事务");
        } else {
            this.txStatusHolder.set(this.transactionManager.getTransaction(TX_DEFINITION));
        }
    }

    public void commitTx() {
        if (this.txStatusHolder.get() == null) {
            throw new IllegalStateException("事务不存在，无法提交事务");
        } else {
            this.transactionManager.commit((TransactionStatus)this.txStatusHolder.get());
            this.txStatusHolder.remove();
        }
    }

    public void rollbackTx() {
        if (this.txStatusHolder.get() == null) {
            throw new IllegalStateException("事务不存在，无法回滚事务");
        } else {
            this.transactionManager.rollback((TransactionStatus)this.txStatusHolder.get());
            this.txStatusHolder.remove();
        }
    }

    public boolean hasTx() {
        return this.txStatusHolder.get() != null;
    }

    public void validate() {
        if (this.transactionManager == null) {
            throw new IllegalStateException("事务执行器内部要素不全");
        }
    }



}
