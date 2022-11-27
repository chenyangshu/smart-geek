package com.smartgeek.component.operation;

import java.util.function.Supplier;

/**
 * @author cys 2022/1/28 9:55 下午
 */
public interface Create<T> {

  UpdateHandler<T> create(Supplier<T> supplier);

}
