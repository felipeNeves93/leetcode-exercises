package com.leetcode.exercices.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {


  public List<String> fizzBuzz(int n) {
    int startingNumber = 1;
    List<String> fizzBuzz = new ArrayList<>();

    while (startingNumber <= n) {
      if (startingNumber % 3 == 0 && startingNumber % 5 == 0) {
        fizzBuzz.add("FizzBuzz");
      } else if (startingNumber % 3 == 0) {
        fizzBuzz.add("Fizz");
      } else if (startingNumber % 5 == 0) {
        fizzBuzz.add("Buzz");
      } else {
        fizzBuzz.add(startingNumber + "");
      }

      startingNumber++;
    }
    return fizzBuzz;

  }
}
