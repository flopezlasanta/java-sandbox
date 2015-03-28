package org.teraflopx.jsandboox.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ArrayOperationsTest {

  @Test
  public void testQuickSort() {
    int[] data = new int[] {2, 8, 6, 4, 9, 5, 7, 3, 10, 1};
    ArrayOperations.quickSort(data);
  }

  @Test
  public void testPermutations() {
    ArrayOperations.findPermutations("abc");
  }

  @Test
  public void testMergeSort() {
    int[] data = new Random().ints().limit(100).toArray();
    ArrayOperations.mergeSort(data);
  }

  @Test
  public void testBinarySearchRecursive() {
    int[] data = new Random().ints().limit(100).toArray();

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
