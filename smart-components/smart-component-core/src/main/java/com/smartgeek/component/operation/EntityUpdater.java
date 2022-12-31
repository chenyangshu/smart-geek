package com.smartgeek.component.operation;

import com.google.common.base.Preconditions;
import com.smartgeek.component.constants.CodeEnum;
import com.smartgeek.component.exception.BusinessException;
import com.smartgeek.component.validate.UpdateGroup;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * 实体更新程序
 *
 * @author chenyangshu
 * @date 2022/09/04
 */
@Slf4j
public class EntityUpdater<T> extends BaseEntityOperation implements Loader<T>,
        UpdateHandler<T>, Executor<T> {

    private final BaseRepository<T> port;
    private T entity;
    private Consumer<T> successHook = t -> log.info("update success");
    private Consumer<? super Throwable> errorHook = e -> e.printStackTrace();

    public EntityUpdater(BaseRepository<T> port) {
        this.port = port;
    }

    @Override
    public Optional<T> execute() {
        doValidate(this.entity, UpdateGroup.class);
        T save = Try.of(() -> {
                    port.updateById(entity);
                    return this.entity;
                })
                .onSuccess(successHook)
                .onFailure(errorHook).
                getOrNull();
        return Optional.ofNullable(save);
    }


    @Override
    public UpdateHandler<T> loadById(Serializable id) {
        Preconditions.checkArgument(Objects.nonNull(id), "id is null");
        Optional<T> loadEntity = port.findById(id);
        this.entity = loadEntity.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError));
        return this;
    }

    @Override
    public UpdateHandler<T> load(Supplier<T> t) {
        this.entity = t.get();
        return this;
    }

    @Override
    public Executor<T> update(Consumer<T> consumer) {
        Preconditions.checkArgument(Objects.nonNull(entity), "entity is null");
        consumer.accept(this.entity);
        return this;
    }

    @Override
    public Executor<T> successHook(Consumer<T> consumer) {
        this.successHook = consumer;
        return this;
    }

    @Override
    public Executor<T> errorHook(Consumer<? super Throwable> consumer) {
        this.errorHook = consumer;
        return this;
    }

}