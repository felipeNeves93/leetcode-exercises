# Reverse Integer - Thought Process

## Problem Analysis
Given a signed 32-bit integer `x`, we need to return the digits of `x` reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2³¹, 2³¹ - 1]`, we should return 0.

## Key Challenges
1. **Handling Negative Numbers**: The solution must correctly handle negative integers.
2. **Integer Overflow**: We need to detect potential overflow before it happens since we can't use 64-bit integers.
3. **Trailing Zeros**: Numbers ending with zeros should have those zeros removed when reversed.

## Solution Approach

### Algorithm
1. **Initialize Boundaries**: Store the minimum and maximum 32-bit integer values to check for overflow.
2. **Handle Edge Cases**: If `x` is already at the boundaries, return 0 immediately.
3. **Reverse Process**:
   - Extract the last digit using modulo 10.
   - Check for potential overflow before updating the reversed number.
   - Update the reversed number by multiplying by 10 and adding the last digit.
   - Remove the last digit from `x` using integer division by 10.
4. **Return Result**: Return the reversed number or 0 if overflow was detected.

### Complexity Analysis
- **Time Complexity**: O(log₁₀(n)) - We process each digit of the number exactly once.
- **Space Complexity**: O(1) - We use a constant amount of space regardless of the input size.

## Key Insights
1. **Modulo Operation**: `x % 10` gives the last digit of `x`.
2. **Integer Division**: `x / 10` removes the last digit from `x`.
3. **Overflow Prevention**: We check for potential overflow before updating the reversed number by comparing with `Integer.MAX_VALUE/10` and `Integer.MIN_VALUE/10`.

## Edge Cases Handled
- Single digit numbers
- Numbers ending with 0
- Negative numbers
- Numbers that would cause overflow when reversed
- The minimum 32-bit integer value (-2³¹)

## Example Walkthrough
Let's reverse `123`:
1. reversed = 0, x = 123
2. lastDigit = 123 % 10 = 3
3. reversed = 0 * 10 + 3 = 3
4. x = 123 / 10 = 12
5. lastDigit = 12 % 10 = 2
6. reversed = 3 * 10 + 2 = 32
7. x = 12 / 10 = 1
8. lastDigit = 1 % 10 = 1
9. reversed = 32 * 10 + 1 = 321
10. x = 1 / 10 = 0 (loop ends)
11. Return 321
