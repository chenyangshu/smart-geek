package com.smartgeek.component.command;

public interface BaseAppService<I, O> {
    O execute(I input);
}
