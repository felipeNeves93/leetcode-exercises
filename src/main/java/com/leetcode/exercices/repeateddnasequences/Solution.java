package com.leetcode.exercices.repeateddnasequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> repeatedSequences = new HashSet<String>();
    Set<String> sequences = new HashSet<String>();

    int left = 0;
    int right = 10;

    while (right <= s.length()) {
      String sequence = s.substring(left, right);

      if (sequences.contains(sequence)) {
        repeatedSequences.add(sequence);
      }

      sequences.add(sequence);
      left++;
      right++;
    }

    return new ArrayList(repeatedSequences);
  }
}
