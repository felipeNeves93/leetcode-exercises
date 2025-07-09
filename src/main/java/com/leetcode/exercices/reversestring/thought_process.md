# Reverse String - Thought Process

## Problem Analysis
We need to reverse a string that's given as an array of characters in-place, meaning we must modify the input array directly without using extra space for another array.

## Key Constraints
1. **In-place Modification**: Must modify the input array directly
2. **Space Complexity**: Must use O(1) extra memory
3. **Input Range**: The string can be up to 10^5 characters long
4. **Character Set**: All characters are printable ASCII characters

## Solution Approach: Two Pointers

### Algorithm
1. **Initialize Pointers**:
   - `left` pointer starts at the beginning of the array (index 0)
   - `right` pointer starts at the end of the array (last index)

2. **Swap Characters**:
   - While `left` is less than `right`:
     - Swap the characters at `left` and `right` indices
     - Move `left` pointer one step forward
     - Move `right` pointer one step backward

### Complexity Analysis
- **Time Complexity**: O(n)
  - We visit each character exactly once (n/2 swaps for n characters)
  - Each swap operation is O(1)
- **Space Complexity**: O(1)
  - We only use a constant amount of extra space (for the `temp` variable)
  - The input array is modified in-place

## Key Insights
1. **In-place Swapping**: By using two pointers, we can reverse the array without needing extra space for another array.
2. **Termination Condition**: The loop continues until the `left` pointer is no longer less than the `right` pointer. When they meet (for odd-length arrays) or cross each other (for even-length arrays), we've processed all necessary swaps.
3. **Efficiency**: This approach is optimal because it minimizes both time and space complexity.

## Edge Cases Handled
- Empty array (though constraints say length is at least 1)
- Single character array (no swap needed)
- Even and odd length arrays
- Arrays with repeated characters
- Arrays with special characters (handled since we're working with any printable ASCII character)

## Example Walkthrough
Let's reverse `['h','e','l','l','o']`:
1. Initial: ['h','e','l','l','o'] (left=0, right=4)
   - Swap 'h' and 'o': ['o','e','l','l','h']
   - left=1, right=3
2. Swap 'e' and 'l': ['o','l','l','e','h']
   - left=2, right=2 (loop ends as left is not < right)
3. Final result: ['o','l','l','e','h']

## Alternative Approaches Considered
1. **Using a Stack**:
   - Would require O(n) extra space
   - Not optimal for space complexity

2. **Using Built-in Functions**:
   - Some languages provide built-in reverse functions
   - But the problem is about understanding the underlying algorithm

3. **Recursive Approach**:
   - Could be implemented but would use O(n) space for the call stack
   - Not as space-efficient as the iterative two-pointer approach
