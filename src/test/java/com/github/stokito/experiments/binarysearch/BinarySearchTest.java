package com.github.stokito.experiments.binarysearch;

import com.github.stokito.experiments.binarysearch.BinarySearch;
import org.junit.Test;

public class BinarySearchTest {

  private static final byte[] HAYSTACK = new byte[]{
    0, 1, 2, 3, 4, 5, 6, 7,
    8, 9, 10, 11, 12, 13, 14, 15,
    16, 17, 18, 19, 20, 21, 22, 23,
    24, 25, 26, 27, 28, 29, 30, 31
  };

  @Test
  public void name() {
    for (int o = 0; o < 1000; o++) {
      int i = BinarySearch.binarySearch0(HAYSTACK, 0, 33, (byte) 31);
      assert i == 31;
    }
  }
/*
  @Test
  public void name() {
    int[] stack = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int i = BinarySearch.binarySearch(stack, 8);
    Arrays.binarySearch()
    assert i == 7;

    int low = 0;
    int high= Integer.MAX_VALUE;
    int mid = (low + high) / 2;
    assert mid == 1073741823;

    low = mid + 1;
    mid = low + ((high - low) / 2);
    assert mid == 1610612735;
  }*/
}