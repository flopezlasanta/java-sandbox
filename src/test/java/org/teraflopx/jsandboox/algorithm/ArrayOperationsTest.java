package org.teraflopx.jsandboox.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ArrayOperationsTest {

  @Test
  public void testBinarySearchRecursive() {
    int[] data = new int[] {1, 2, 6, 7, 8, 12};

    long start = System.nanoTime();

    assertEquals(ArrayOperations.binarySearchRecursive(3, data, 0, data.length - 1), -1);
    for (int i = 0; i < data.length; i++)
      assertEquals(ArrayOperations.binarySearchRecursive(data[i], data, 0, data.length - 1), i);

    long end = System.nanoTime();

    System.out.println("Elapsed time (ms): " + TimeUnit.NANOSECONDS.toMillis(end - start));
  }

  @Test
  public void testBinarySearchLinear() {
    int[] data = new int[] {1, 2, 6, 7, 8, 12};

    long start = System.nanoTime();

    assertEquals(ArrayOperations.binarySearchLinear(3, data, 0, data.length - 1), -1);
    for (int i = 0; i < data.length; i++)
      assertEquals(ArrayOperations.binarySearchLinear(data[i], data, 0, data.length - 1), i);

    long end = System.nanoTime();

    System.out.println("Elapsed time (ms): " + TimeUnit.NANOSECONDS.toMillis(end - start));
  }
}
