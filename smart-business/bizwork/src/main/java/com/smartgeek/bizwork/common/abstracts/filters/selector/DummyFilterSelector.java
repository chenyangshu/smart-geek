package com.smartgeek.bizwork.common.abstracts.filters.selector;

import java.util.List;

public class DummyFilterSelector implements FilterSelector {

  @Override
  public boolean matchFilter(String currentFilterName) {
    return false;
  }

  @Override
  public List<String> getFilterNames() {
    return null;
  }
}