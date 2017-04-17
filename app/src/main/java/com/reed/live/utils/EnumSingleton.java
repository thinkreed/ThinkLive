package com.reed.live.utils;

/**
 * Created by thinkreed on 2017/4/11.
 */

public enum EnumSingleton {
  INSTANCE;

  private String mName = "hah";

  public String getName() {
    return mName;
  }
}
