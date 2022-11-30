package com.smartgeek.component.operation;

import java.io.Serializable;
import java.util.function.Supplier;


/**
 * 装载机
 *
 * @author chenyangshu
 * @date 2022/09/04
 */
public interface Loader<T> {

    UpdateHandler<T> loadById(Serializable id);

    UpdateHandler<T> load(Supplier<T> t);

}
