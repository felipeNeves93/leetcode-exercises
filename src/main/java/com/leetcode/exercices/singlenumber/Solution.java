package com.leetcode.exercices.singlenumber;

public class Solution {

  public int singleNumber(int[] nums) {
    int singleNumber = 0;

    for (int num : nums) {
      singleNumber = singleNumber ^ num;
    }

    return singleNumber;
  }
}
