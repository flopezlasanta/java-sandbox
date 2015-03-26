package org.teraflopx.jsandboox.util;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class SafeDateFormatTest {

  @Test
  public void testWithMultipleThreads() throws InterruptedException {
    final String PATTERN = "yyyy.MM.dd_HH.mm.ss";
    final Date DATE = new Date();

    long start = System.nanoTime();

    int numThreads = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    for (int i = 0; i < numThreads; i++) {
      executor.execute(() -> SafeDateFormat.INSTANCE.get(PATTERN).format(DATE));
    }
    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);

    long end = System.nanoTime();

    System.out.println("Elapsed time (ms): " + TimeUnit.NANOSECONDS.toMillis(end - start));
  }
}
