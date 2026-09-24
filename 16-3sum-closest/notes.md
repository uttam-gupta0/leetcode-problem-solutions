# Approach


1. Sort the array.
2. Fix one element using `i`.
3. Use two pointers:
   - `left = i + 1`
   - `right = nums.length - 1`
4. Calculate:
   `sum = nums[i] + nums[left] + nums[right]`
5. Compare the current sum with the target.
6. If the current sum is closer to the target, update `closest`.
7. If `sum < target`, move `left++`.
8. If `sum > target`, move `right--`.
9. If `sum == target`, return immediately because this is the exact answer.

# Complexity

- Time Complexity: `O(n²)`
- Space Complexity: `O(1)` excluding sorting space.

# Notes

- Unlike 3Sum, we do NOT need to find sum exactly equal to 0.
- We need the sum that is closest to the given target.
- Sorting allows us to use two pointers.
- `Math.abs(sum - target)` tells us how far the current sum is from the target.

Example:

`nums = [-1, 2, 1, -4]`
`target = 1`

Possible sums:

`-1 + 2 + 1 = 2`

Difference:

`|2 - 1| = 1`

So the answer is:

`2`

# Pattern

Sort + Fix One Element + Two Pointers

`for i` → `left` → `right`

3Sum:
Find sum == 0

3Sum Closest:
Find sum closest to target
