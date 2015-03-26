package org.teraflopx.jsandboox.algorithm;

public class BinarySearchArray {

  private BinarySearchArray() {}

  public static int findRecursive(int key, int[] data, int start, int end) {
    if (start > end)
      return -1;

    int middle = (start + end) / 2;

    if (data[middle] < key)
      return findRecursive(key, data, middle + 1, end);
    else if (data[middle] > key)
      return findRecursive(key, data, start, middle - 1);

    return middle;
  }

  public static int findLinear(int key, int[] data, int start, int end) {
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
