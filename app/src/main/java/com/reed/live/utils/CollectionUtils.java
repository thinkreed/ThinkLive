package com.reed.live.utils;

import java.util.Collection;

/**
 * Created by thinkreed on 2017/4/12.
 */

public class CollectionUtils {
  private CollectionUtils() {}

  public static <T> boolean isEmpty(Collection<T> collection) {
    return collection == null || collection.isEmpty();
  }

  public static <T> void add(Collection<T> collection, T item) {
    if (item != null) {
      collection.add(item);
    }
  }
}
