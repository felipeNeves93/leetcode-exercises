# Longest Palindromic Substring - Solution Analysis

## Problem Understanding
Given a string `s`, we need to find the longest palindromic substring in it. A palindrome is a string that reads the same backward as forward, such as "madam" or "racecar".

## Intuition
The key insight is that a palindrome mirrors around its center. For any palindrome, there exists a center point (or two center points for even-length palindromes) from which the string reads the same in both directions.

## Approach: Expand Around Center
This solution uses an "expand around center" approach which is both intuitive and efficient. Here's how it works:

1. **Center Points**: For each character in the string, we treat it as the center of a potential palindrome and expand outwards to find the longest possible palindrome.
2. **Odd and Even Lengths**: We need to handle both odd and even length palindromes:
   - For odd length: The center is a single character (e.g., "racecar" has center 'e')
   - For even length: The center is between two characters (e.g., "abba" has center between the two 'b's)
3. **Tracking the Longest**: We keep track of the start and end indices of the longest palindrome found so far.

## Solution Code
```java
public class Solution {
    int start = 0;
    int end = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);     // Odd length
            expandAroundCenter(s, i, i + 1); // Even length
        }
        return s.substring(start, end + 1);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left = left + 1;
        right = right - 1;

        if (end - start + 1 < right - left + 1) {
            start = left;
            end = right;
        }
    }
}
```

## Complexity Analysis

- **Time Complexity**: O(n²) where n is the length of the input string.
  - We expand around each of the 2n-1 possible centers (n centers for odd length and n-1 centers for even length).
  - In the worst case, each expansion could go up to O(n) time.
  - Therefore, the total time complexity is O(n) * O(n) = O(n²).

- **Space Complexity**: O(1)
  - We only use a constant amount of extra space (just a few variables to store indices).

## Key Insights
1. **Center Expansion**: The key observation is that every palindrome has a center from which it can be expanded.
2. **Two Types of Centers**: We need to check both single-character centers (for odd-length palindromes) and two-character centers (for even-length palindromes).
3. **Efficiency**: While the time complexity is O(n²), this is optimal for this problem as we need to check all possible palindromic substrings in the worst case.
4. **No Additional Space**: The algorithm runs in constant space, making it very memory efficient.

## Edge Cases
- Empty string
- Single character string
- Entire string is a palindrome
- No palindromes longer than 1 character
- String with all identical characters
