# Single Number Solution Analysis

## Problem Understanding
The problem requires finding a single number in an array where every other number appears exactly twice. The solution must have:
- O(n) time complexity
- O(1) space complexity

## Solution Approach: Bit Manipulation (XOR)

The solution uses the XOR (exclusive OR) bitwise operation, which has these key properties:
1. **Commutative**: A ^ B = B ^ A
2. **Associative**: A ^ (B ^ C) = (A ^ B) ^ C
3. **Identity**: A ^ 0 = A
4. **Self-inverse**: A ^ A = 0

### How It Works
1. Initialize `singleNumber` to 0
2. Iterate through each number in the array, applying XOR between `singleNumber` and the current number
3. Numbers appearing twice will cancel each other out (A ^ A = 0)
4. The remaining number will be the single number (A ^ 0 = A)

### Example Walkthrough
For input [4,1,2,1,2]:
- 0 ^ 4 = 4
- 4 ^ 1 = 5
- 5 ^ 2 = 7
- 7 ^ 1 = 6 (because 5 ^ 1 ^ 1 = 5)
- 6 ^ 2 = 4 (final result)

## Performance Analysis

### Time Complexity: O(n)
- We iterate through the array exactly once
- Each XOR operation is O(1)
- Total operations are proportional to the input size n

### Space Complexity: O(1)
- We use a single integer variable (`singleNumber`) regardless of input size
- No additional data structures are used

## Why This Solution Is Optimal
1. **Meets Constraints**: Achieves O(n) time and O(1) space
2. **Single Pass**: Only needs to traverse the array once
3. **No Extra Space**: Doesn't require additional data structures
4. **Efficient**: Uses bitwise operations which are very fast

## Alternative Approaches

1. **Hash Set**:
   - Time: O(n)
   - Space: O(n)
   - Less efficient due to extra space

2. **Sorting**:
   - Time: O(n log n)
   - Space: O(1) if sorted in-place
   - Slower due to sorting

3. **Math**:
   - 2 * (sum of unique elements) - sum of all elements
   - Requires O(n) space for the set of unique elements

## Edge Cases Handled
- Single element array: Returns that element
- Maximum size array (3 * 10^4 elements): Handled efficiently
- Negative numbers: Handled correctly by XOR operation
- Large numbers: Within integer range, handled by XOR

## Key Insight
The XOR operation's property of canceling out pairs (A ^ A = 0) and preserving the single number (A ^ 0 = A) makes it perfect for this problem, allowing us to find the solution in constant space with a single pass through the array.
