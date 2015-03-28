package org.teraflopx.jsandboox.algorithm;

import java.util.Arrays;

// utility class
public class ArrayOperations {

  // no need to instantiate
  private ArrayOperations() {}

  // quicksort algorithm
  public static void quickSort(int[] data) {
    quickSort(data, 0, data.length - 1);
  }

  // TODO check if an array is sorted or not
  public static boolean isSorted(int[] data) {
    return true;
  }

  // TODO ...and return number of rotations
  public static boolean isSortedRotated(int[] data) {
    return true;
  }

  // TODO let´s play with a circular sorted array
  public static void binarySearchCircular() {

  }

  // merge sort algorithm
  public static void mergeSort(int[] data) {
    int[] helper = new int[data.length]; // a helper is needed!
    mergeSort(data, helper, 0, data.length - 1);
    System.out.println(Arrays.toString(data));
  }

  // obtain all the permutations
  public static void findPermutations(String str) {
    permute("", str);
  }

  // perform a binary search recursive; note: assumes the array is sorted
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

  // perform a binary search linear; note: assumes the array is sorted
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

  private static void quickSort(int[] data, int low, int high) {
    int i = low, j = high;
    int pivot = data[low + (high - low) / 2];

    while (i <= j) {
      while (data[i] < pivot) {
        i++;
      }
      while (data[j] > pivot) {
        j--;
      }

      // why not i < j only? because when i == j we have to break the loop by incrementing!
      if (i <= j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;

        i++;
        j--;
      }
    }
    // Recursion
    if (low < j)
      quickSort(data, low, j);
    if (i < high)
      quickSort(data, i, high);
  }

  private static void permute(String prefix, String str) {
    if (str.length() == 0)
      System.out.println(prefix);
    for (int i = 0; i < str.length(); i++)
      permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
  }

  private static void mergeSort(int[] data, int[] helper, int low, int high) {
    if (low < high) {
      int middle = low + (high - low) / 2;
      mergeSort(data, helper, low, middle);
      mergeSort(data, helper, middle + 1, high);
      merge(data, helper, low, middle, high);
    }
  }

  private static void merge(int[] data, int[] helper, int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      helper[i] = data[i];
    }

    int i = low;
    int x = low;
    int y = middle + 1;
    while (x <= middle && y <= high) {
      if (helper[x] < helper[y])
        data[i++] = helper[x++];
      else
        data[i++] = helper[y++];
    }

    while (x <= middle)
      data[i++] = helper[x++];
  }
}

// TODO no need to sort / search for empty arrays!
// TODO add safety measures for wrong input values
