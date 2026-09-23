# 26. Remove Duplicates from Sorted Array
## Approach
Two-pointer / in-place overwrite technique, possible because the array is already sorted so duplicates are always adjacent.

- `k` tracks the position where the next unique element should be written (starts at `1`, since `nums[0]` is always unique).
- `i` scans the array from index `1` onward.
- Whenever `nums[i]` differs from `nums[i - 1]`, it's a new unique value, so it's copied to `nums[k]` and `k` is incremented.
- Duplicate values are simply skipped over — no shifting or extra array needed.
- `k` at the end equals the count of unique elements, which is what the problem asks the function to return.

## Complexity
- **Time:** `O(n)` — single pass through the array.
- **Space:** `O(1)` — modifies the array in place, no auxiliary data structures.

## Notes
- Relies on the array being sorted; doesn't work as-is on unsorted input.
- Elements beyond index `k - 1` are left in an undefined state, per the problem's requirements — only the first `k` elements matter.
- Same pattern generalizes to "remove duplicates, allow at most 2 occurrences" (LeetCode 80) by comparing against `nums[k - 2]` instead of `nums[k - 1]`.
