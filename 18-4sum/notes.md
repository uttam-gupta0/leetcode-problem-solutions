# Approach

1. Sort the array first.
2. Use the first `for` loop to fix the first number `nums[i]`.
3. Use the second `for` loop to fix the second number `nums[j]`.
4. Use two pointers:
   - `left = j + 1`
   - `right = nums.length - 1`
5. Calculate the sum of four numbers:
   
   `sum = nums[i] + nums[j] + nums[left] + nums[right]`

6. Use `long` for `sum` to avoid integer overflow.
7. If `sum == target`:
   - Add the four numbers to `result`.
   - Move `left` and `right`.
8. If `sum < target`:
   - Move `left++` to increase the sum.
9. If `sum > target`:
   - Move `right--` to decrease the sum.
10. Skip duplicate values for `i`, `j`, `left`, and `right` to avoid duplicate quadruplets.

# Complexity

- Time Complexity: `O(n³)`
- Space Complexity: `O(1)` excluding the result list.
- Sorting takes `O(n log n)`.
- Three nested levels of searching give `O(n³)`.

# Notes

- 4Sum means finding **four numbers** whose sum equals the target.
- The array is sorted so that the two-pointer technique can be used.
- We fix two numbers first:

  `nums[i]` and `nums[j]`

- Then find the remaining two numbers using:

  `left` and `right`

- Main pattern:

  `Fix i → Fix j → Two Pointers`

- `long` is used because the sum of four `int` values can overflow.

# Example

```text
nums = [1, 0, -1, 0, -2, 2]
target = 0
