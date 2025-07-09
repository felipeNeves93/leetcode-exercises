# Longest Common Prefix - Thought Process

## Problem Analysis
We need to find the longest common prefix string among an array of strings. If there's no common prefix, we should return an empty string.

## Key Constraints
1. **Input Range**: 
   - 1 <= strs.length <= 200
   - 0 <= strs[i].length <= 200
   - Strings consist of only lowercase English letters
2. **Edge Cases**:
   - Empty array (though constraints say length is at least 1)
   - Empty strings in the array
   - No common prefix
   - All strings are identical
   - Very long strings (up to 200 characters)

## Solution Approach: Horizontal Scanning

### Algorithm
1. **Initial Check**:
   - If the input array is empty, return an empty string immediately
   - Take the first string as the initial prefix

2. **Iterative Comparison**:
   - For each subsequent string in the array:
     - While the current string doesn't start with the current prefix:
       - Shorten the prefix by removing the last character
       - If prefix becomes empty, return empty string immediately
   - Return the final prefix after processing all strings

### Complexity Analysis
- **Time Complexity**: O(S), where S is the sum of all characters in all strings
  - In the worst case, we compare all characters of all strings
  - Best case: O(minLen * n) where minLen is the length of the shortest string
- **Space Complexity**: O(1)
  - We only use constant extra space
  - The space used for the prefix is part of the output

## Key Insights
1. **Prefix Property**: The common prefix can only be as long as the shortest string in the array
2. **Progressive Reduction**: By comparing the current prefix with each string and reducing it as needed, we efficiently find the common prefix
3. **Early Termination**: The algorithm can terminate early if the prefix becomes empty at any point

## Edge Cases Handled
- Single string in array (returns the string itself)
- Empty string in array (returns empty string)
- No common prefix (returns empty string)
- All strings identical (returns the full string)
- Very long strings (handled efficiently)

## Example Walkthrough
Let's find the LCP of ["flower","flow","flight"]:
1. prefix = "flower"
2. Compare with "flow":
   - "flow" doesn't start with "flower"
   - Reduce prefix to "flowe"
   - Then to "flow"
   - Now "flow" starts with "flow"
3. Compare with "flight":
   - "flight" doesn't start with "flow"
   - Reduce prefix to "flo"
   - Then to "fl"
   - Now "flight" starts with "fl"
4. Final result: "fl"

## Alternative Approaches Considered
1. **Vertical Scanning**: 
   - Compare characters from the beginning of all strings
   - Potentially better for cases where the shortest string is very short
   - Same time complexity but might be faster in practice for some cases

2. **Divide and Conquer**:
   - Split the array into two halves
   - Find LCP of each half
   - Find LCP of the two results
   - Time complexity: O(S), same as current approach
   - More complex implementation with recursive calls

3. **Binary Search**:
   - Find the shortest string
   - Do binary search on the length of the prefix
   - Check if all strings have that prefix
   - Time complexity: O(S*log(m)) where m is the length of the shortest string
   - More complex but better for very large strings

## Optimization Notes
- The current implementation is simple and efficient for most cases
- For very large strings or specific distributions of strings, vertical scanning might be slightly more efficient
- The algorithm handles all edge cases gracefully and has optimal time and space complexity
