# Reverse Integer

## Problem
Given a signed 32-bit integer `x`, reverse its digits. If the reversed integer goes outside the 32-bit signed integer range, return `0`.

---

## Approach

Use the **Digit Extraction + Math** technique.

1. Initialize `rev = 0`.
2. Extract the last digit using:
   ```java
   int digit = x % 10;
3. Remove the last digit from `x`:
   ```java
   x = x / 10;
4. Check for **integer overflow** before multiplying `rev` by `10`.

5. If overflow is possible, return `0`.

6. Add the extracted digit to `rev`:
   ```java
   rev = rev * 10 + digit;
7. Continue until `x == 0`.
8. Return `rev`.

## Complexity

- **Time:** `O(log₁₀(n))`
- **Space:** `O(1)`

---

## Notes

1. `% 10` gives the last digit.
2. `/ 10` removes the last digit.
3. `rev * 10 + digit` builds the reversed number.
4. Always check **overflow before** doing `rev * 10`.
5. Java `int` range:
   ```text
   Integer.MIN_VALUE = -2147483648
   Integer.MAX_VALUE = 2147483647
6. For positive numbers, the last allowed digit is `7`.
7. For negative numbers, the last allowed digit is `-8`.
8. Main pattern: **Digit Extraction + Math**
9. **Spot It Instantly:** If the problem asks to reverse digits of an integer → think **% 10 → / 10 → build result**.
