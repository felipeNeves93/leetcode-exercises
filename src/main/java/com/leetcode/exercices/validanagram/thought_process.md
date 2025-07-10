# Valid Anagram - Thought Process

## Problem Analysis
We need to determine if two strings are anagrams of each other. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Key Constraints
1. **Input**: 
   - Two strings `s` and `t`
   - 1 <= s.length, t.length <= 5 * 10^4
   - Strings consist of lowercase English letters
2. **Output**:
   - `true` if `t` is an anagram of `s`
   - `false` otherwise

## Solution Approach: Character Frequency Counting

### Algorithm
1. **Length Check**:
   - If the lengths of `s` and `t` are different, they can't be anagrams
   - This provides an O(1) early exit for many cases

2. **Frequency Array Initialization**:
   - Create an integer array `alphabet` of size 26 (one for each lowercase letter)
   - This array will track the difference in character counts between the two strings

3. **First Pass - Count Characters in `s`**:
   - For each character in `s`:
     - Increment the corresponding index in `alphabet`
     - `s.charAt(i) - 'a'` converts 'a' to 0, 'b' to 1, ..., 'z' to 25

4. **Second Pass - Validate Against `t`**:
   - For each character in `t`:
     - Decrement the corresponding index in `alphabet`
     - If any count goes below zero, `t` has more of that character than `s`
     - Early return `false` if this happens

5. **Result**:
   - If we complete both passes without finding discrepancies, the strings are anagrams

### Complexity Analysis
- **Time Complexity**: O(n)
  - We make two passes through the strings: O(n + n) = O(n)
  - Each pass is linear relative to the length of the strings
  - All operations within the loops are O(1)
- **Space Complexity**: O(1)
  - We use a fixed-size array of 26 integers
  - Space usage is constant regardless of input size

## Key Insights
1. **Early Length Check**: Quickly eliminates non-anagrams of different lengths
2. **Single Array for Counting**: Efficiently tracks character frequencies using array indexing
3. **Incremental Validation**: Second pass both validates and checks for excess characters
4. **ASCII Value Utilization**: Leverages ASCII values for efficient character-to-index mapping

## Edge Cases Handled
- Empty strings (returns true for two empty strings)
- Strings of different lengths (immediate false)
- Strings with same lengths but different characters
- Strings with same characters but different frequencies
- Maximum length strings (5 * 10^4 characters)
- Strings with all identical characters
- Strings with all unique characters

## Example Walkthrough
For `s = "anagram"`, `t = "nagaram"`:
1. Lengths are equal (7), continue
2. First pass (s = "anagram"):
   - a: [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1] (a, g, m, n, r)
   - n: [1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1]
   - ... (all characters counted)
3. Second pass (t = "nagaram"):
   - n: [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1]
   - a: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1]
   - ... (all characters verified)
4. Final check: All counts are zero → return true

## Alternative Approaches
1. **Sorting**:
   - Sort both strings and compare
   - Time: O(n log n) - worse than current solution
   - Space: O(n) - for the character arrays
   - More concise but less efficient

2. **Hash Map**:
   - Use a hash map to count characters
   - Same time complexity but more overhead than array
   - More flexible for Unicode characters

3. **Single Pass with Array**:
   - Use one array, increment for s and decrement for t in a single loop
   - Then check if all counts are zero
   - Similar performance, slightly different implementation

## Optimization Notes
1. **Array vs HashMap**:
   - Array is more efficient for fixed character sets (like lowercase English letters)
   - HashMap would be better for Unicode characters

2. **Early Exit**:
   - The current implementation has an early exit when counts go negative
   - This can save time for some non-anagram cases

3. **Memory Efficiency**:
   - Using a single array minimizes memory usage
   - No additional data structures are created
