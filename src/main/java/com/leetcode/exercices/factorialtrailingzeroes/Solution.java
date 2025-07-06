package com.leetcode.exercices.factorialtrailingzeroes;

public class Solution {

  public int trailingZeroes(int n) {
    int count = 0;
    int currentPowerOfFive = 5;

    while (n >= currentPowerOfFive) {
      count += (n / currentPowerOfFive);
      currentPowerOfFive *= 5;
    }

    return count;
  }

}
