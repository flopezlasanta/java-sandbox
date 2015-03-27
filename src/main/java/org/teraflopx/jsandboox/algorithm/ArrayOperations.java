package org.teraflopx.jsandboox.algorithm;

public class ArrayOperations {

  private ArrayOperations() {}

  // TODO
  public static void quickSort() {}

  // TODO
  public static void mergeSort() {}

  // TODO
  public static boolean isSorted() {
    return true;
  }

  // TODO and return number of rotations
  public static boolean isSortedRotated() {
    return true;
  }

  // TODO let´s play with a circular sorted array
  public static void binarySearchCircular() {

  }

  // note: assumes the array is sorted
  public static int binarySearchRecursive(int key, int[] data, int start, int end) {
    if (start > end)
      return -1;

    int middle = (start + end) / 2;

    if (data[middle] < key)
      return binarySearchRecursive(key, data, middle + 1, end);
    else if (data[middle] > key)
      return binarySearchRecursive(key, data, start, middle - 1);

    return middle;
  }

  // note: assumes the array is sorted
  public static int binarySearchLinear(int key, int[] data, int start, int end) {
    while (start < end) {
      int middle = (start + end) / 2;
      if (middle >= end)
        break;

      if (data[middle] < key)
        start = middle + 1;
      else
        end = middle;
    }

    return (start == end && data[start] == key) ? start : -1;
  }
}
