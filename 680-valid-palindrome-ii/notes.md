# Valid Palindrome II

## Problem
Check whether a string can become a palindrome by deleting **at most one character**.

---

## Approach

Use the **Two Pointer** technique.

1. Convert string to `char[]`.
2. Set:
   - `left = 0`
   - `right = n - 1`
3. Compare `arr[left]` and `arr[right]`.
4. If equal:
   - `left++`
   - `right--`
5. If not equal:
   - We can delete either character.
   - Check both possibilities:
     ```java
     isPalindrome(arr, left + 1, right)
     ||
     isPalindrome(arr, left, right - 1)
     ```
6. If either is a palindrome, return `true`.

---

## Important Code

```java
if (arr[left] != arr[right]) {
    return isPalindrome(arr, left + 1, right)
        || isPalindrome(arr, left, right - 1);
}
