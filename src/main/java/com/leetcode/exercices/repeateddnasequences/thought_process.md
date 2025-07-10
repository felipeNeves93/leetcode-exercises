# Repeated DNA Sequences - Thought Process

## Problem Analysis
We need to find all 10-letter-long sequences (substrings) that occur more than once in a given DNA string. The DNA string consists of characters 'A', 'C', 'G', and 'T'.

## Key Constraints
1. **Input Size**: 
   - 1 <= s.length <= 10^5
   - Each character is 'A', 'C', 'G', or 'T'
2. **Output**: 
   - List of all 10-letter sequences that appear more than once
   - Order doesn't matter
   - No duplicates in the result

## Solution Approach: Sliding Window with Hash Set

### Algorithm
1. **Initialization**:
   - Create a set `sequences` to store all seen 10-letter sequences
   - Create a set `repeatedSequences` to store sequences seen more than once
   - Use two pointers (`left` and `right`) to represent the sliding window

2. **Sliding Window**:
   - Slide a window of size 10 across the string
   - For each window:
     - Extract the 10-letter sequence
     - If it's already in `sequences`, add it to `repeatedSequences`
     - Add the sequence to `sequences`
     - Move both pointers right by 1

3. **Result**:
   - Convert `repeatedSequences` to a list and return

### Complexity Analysis
- **Time Complexity**: O((n-10) * 10) = O(n), where n is the length of the string
  - We perform n-10 iterations (sliding window)
  - Each substring operation is O(10) = O(1)
  - Set operations (contains/add) are O(1) on average
- **Space Complexity**: O(n)
  - In the worst case, we might store all possible 10-letter sequences
  - Each sequence is 10 characters long

## Key Insights
1. **Sliding Window**: Efficiently processes all possible 10-letter sequences
2. **Hash Set for Tracking**:
   - First set tracks all seen sequences
   - Second set ensures each repeated sequence is only included once in the result
3. **Early Termination**: No need to process the last 9 characters since they can't form a 10-letter sequence

## Edge Cases Handled
- String shorter than 10 characters (returns empty list)
- No repeated sequences (returns empty list)
- All characters the same (returns the sequence if length >= 10)
- Multiple repetitions of the same sequence (included only once in result)
- Maximum length input (10^5 characters)

## Example Walkthrough
For input "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT":
1. First window: "AAAAACCCCC" (new, add to sequences)
2. Next window: "AAAACCCCCA" (new, add to sequences)
3. ...
4. Window: "CCCCCAAAAA" (new, add to sequences)
5. ...
6. Window: "AAAAACCCCC" (seen before, add to repeatedSequences)
7. ...
8. Window: "CCCCCAAAAA" (seen before, add to repeatedSequences)
9. Final result: ["AAAAACCCCC", "CCCCCAAAAA"]

## Optimization Notes
1. **String Hashing**: 
   - Current approach uses string objects which have some overhead
   - Could be optimized by using bit manipulation to represent sequences as integers
   - Would reduce space usage and potentially improve performance

2. **Alternative Data Structure**:
   - Using a HashMap to count occurrences might be more memory efficient for some cases
   - Would allow finding sequences that appear exactly k times

3. **Early Exit**:
   - If the remaining characters are less than the window size, we could break early
   - Already handled by the while loop condition

## Alternative Approaches
1. **Rabin-Karp Rolling Hash**:
   - More memory efficient for very large inputs
   - Uses polynomial rolling hash to compute hashes in O(1) per window
   - More complex implementation but better theoretical bounds

2. **Trie Data Structure**:
   - Could be used to store and search for sequences
   - More complex and typically not necessary for this problem
   - Useful if we needed to handle variable-length sequences

3. **Suffix Automaton**:
   - Advanced data structure for string matching
   - Overkill for this problem but could be used
   - Useful for more complex sequence analysis
