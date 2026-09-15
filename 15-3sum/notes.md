# Approach

1. Sort the array first.
2. Use a `for` loop to fix one element `nums[i]`.
3. Use two pointers:
   - `left = i + 1`
   - `right = nums.length - 1`
4. Calculate:
   `sum = nums[i] + nums[left] + nums[right]`
5. If `sum == 0`:
   - Add the triplet to the result.
   - Move both pointers.
6. If `sum < 0`, move `left++` to increase the sum.
7. If `sum > 0`, move `right--` to decrease the sum.
8. Skip duplicate values to avoid duplicate triplets.

# Complexity

- Time Complexity: `O(n²)`
- Space Complexity: `O(1)` excluding the result list.
- Sorting takes `O(n log n)`.
- Two-pointer traversal for each element takes `O(n)`.
- Overall: `O(n²)`.

# Notes

- 3Sum means finding three numbers whose sum is `0`.
- Sorting is important because it allows the two-pointer technique.
- For every fixed `nums[i]`, search for two numbers using `left` and `right`.
- If the sum is too small → `left++`.
- If the sum is too large → `right--`.
- Always skip duplicates:
  - `if (i > 0 && nums[i] == nums[i - 1])`
  - Skip duplicate `left` and `right` values after finding a triplet.
- Result type is:
  `List<List<Integer>>`
- Example:
  `[-1, 0, 1, 2, -1, -4]`
- Output:
  `[[-1, -1, 2], [-1, 0, 1]]`

# Pattern

Sort + Fix One Element + Two Pointers

`for i` → `left` → `right`

This is a very important pattern for MNC coding interviews.
