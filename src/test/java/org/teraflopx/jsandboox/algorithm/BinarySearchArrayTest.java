package org.teraflopx.jsandboox.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class BinarySearchArrayTest {

  @Test
  public void testRecursive() {
    int[] data = new int[] {1, 2, 6, 7, 8, 12};

    long start = System.nanoTime();

    assertEquals(BinarySearchArray.findRecursive(3, data, 0, data.length - 1), -1);
    for (int i = 0; i < data.length; i++)
      assertEquals(BinarySearchArray.findRecursive(data[i], data, 0, data.length - 1), i);

    long end = System.nanoTime();

    System.out.println("Elapsed time (ms): " + TimeUnit.NANOSECONDS.toMillis(end - start));
  }

  @Test
  public void testLinear() {
    int[] data = new int[] {1, 2, 6, 7, 8, 12};

    long start = System.nanoTime();

    assertEquals(BinarySearchArray.findLinear(3, data, 0, data.length - 1), -1);
    for (int i = 0; i < data.length; i++)
      assertEquals(BinarySearchArray.findLinear(data[i], data, 0, data.length - 1), i);

    long end = System.nanoTime();

    System.out.println("Elapsed time (ms): " + TimeUnit.NANOSECONDS.toMillis(end - start));
  }
}
