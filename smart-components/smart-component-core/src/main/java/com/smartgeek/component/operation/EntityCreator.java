package com.smartgeek.component.operation;


import com.google.common.base.Preconditions;
import com.smartgeek.component.validate.CreateGroup;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * 实体创建者
 *
 * @author chenyangshu
 * @date 2022/09/04
 */
@Slf4j
public class EntityCreator<T > extends BaseEntityOperation implements Create<T>, UpdateHandler<T>,
        Executor<T> {

    private final IRepositoryPort<T> port;
    private T t;
    private Consumer<T> successHook = t -> log.info("save success");
    private Consumer<? super Throwable> errorHook = e -> e.printStackTrace();

    public EntityCreator(IRepositoryPort<T> port) {
        this.port = port;
    }


    @Override
    public Executor<T> errorHook(Consumer<? super Throwable> consumer) {
        this.errorHook = consumer;
        return this;
    }

    @Override
    public UpdateHandler<T> create(Supplier<T> supplier) {
        this.t = supplier.get();
        return this;
    }

    @Override
    public Executor<T> update(Consumer<T> consumer) {
        Preconditions.checkArgument(Objects.nonNull(t), "entity must supply");
        consumer.accept(this.t);
        return this;
    }

    @Override
    public Optional<T> execute() {
        doValidate(this.t, CreateGroup.class);
        T save = Try.of(() -> {
                    port.create(t);
                    return this.t;
                })
                .onSuccess(successHook)
                .onFailure(errorHook).getOrNull();
        return Optional.ofNullable(save);
    }

    @Override
    public Executor<T> successHook(Consumer<T> consumer) {
        this.successHook = consumer;
        return this;
    }

}

