package com.smartgeek.component.operation;

import java.util.function.Consumer;

/**
 * 更新处理程序
 *
 * @author chenyangshu
 * @date 2022/09/04
 */
public interface UpdateHandler<T> {

    Executor<T> update(Consumer<T> consumer);
}
