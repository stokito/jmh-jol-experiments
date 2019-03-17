package com.github.stokito.experiments.binarysearch;

public class BinarySearch {

  public static int binarySearch0(byte[] a, int fromIndex, int toIndex, byte key) {
    int low = fromIndex;
    int high = toIndex - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      byte midVal = a[mid];
      if (midVal < key)
        low = mid + 1;
      else if (midVal > key)
        high = mid - 1;
      else
        return mid; // key found
    }
    return -(low + 1);  // key not found.
  }

  public static int binarySearch1(byte[] a, int fromIndex, int toIndex, byte key) {
    int low = fromIndex;
    int high = toIndex - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      byte midVal = a[mid];
      if (midVal == key)
        return mid; // key found
      else if (midVal < key)
        low = mid + 1;
      else // if (midVal > key)
        high = mid - 1;
    }
    return -(low + 1);  // key not found.
  }

}
