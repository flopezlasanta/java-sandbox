package org.teraflopx.jsandboox.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

// thread-safe factory of date formatters that maintains an internal cache
public enum SafeDateFormat {

  INSTANCE;

  private final ThreadLocal<Map<String, SimpleDateFormat>> CACHE = ThreadLocal
      .<Map<String, SimpleDateFormat>>withInitial(() -> new HashMap<String, SimpleDateFormat>());

  public SimpleDateFormat get(String pattern) {
    Map<String, SimpleDateFormat> map = CACHE.get();
    if (map == null) {
      map = new HashMap<String, SimpleDateFormat>();
      CACHE.set(map);
    }

    SimpleDateFormat format = map.get(pattern);
    if (format == null) {
      format = new SimpleDateFormat(pattern);
      map.put(pattern, format);
    }

    return format;
  }

}

// TODO consider wrapping CACHE within a SoftReference
// TODO compare performance with joda-time implementation
