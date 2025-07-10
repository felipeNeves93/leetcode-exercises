package com.leetcode.exercices.validanagram;

public class Solution {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] alphabet = new int[27];

    // Increment the amount of chars present in string
    for (int i = 0; i < s.length(); i++) {
      alphabet[s.charAt(i) - 'a']++;
    }

    // Decrement the of chars based on the second string
    for (int i = 0; i < s.length(); i++) {
      alphabet[t.charAt(i) - 'a']--;

      if (alphabet[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
