package com.smartgeek.bizwork.common.abstracts.pipeline;

public interface Handler<I, O> {

  /**
   * 处理I 返回O
   *
   * @param input
   * @return
   */
  O process(I input);

}