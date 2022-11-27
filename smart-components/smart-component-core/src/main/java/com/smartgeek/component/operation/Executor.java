package com.smartgeek.component.operation;

import java.util.Optional;
import java.util.function.Consumer;


/**
 * 执行人
 *
 * @author chenyangshu
 * @date 2022/09/04
 */
public interface Executor<T> {

  Optional<T> execute();

  Executor<T> successHook(Consumer<T> consumer);

  Executor<T> errorHook(Consumer<? super Throwable> consumer);

}
