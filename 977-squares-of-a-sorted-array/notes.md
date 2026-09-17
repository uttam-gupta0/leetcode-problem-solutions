# Squares of a Sorted Array

## Problem
Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number, also sorted in non-decreasing order.

---

## Approach

1. Create a new array `result` with the same size as `nums`.
2. Traverse the `nums` array using a `for` loop.
3. Square each element:
   ```java
   int arr = nums[i] * nums[i];
4. Store the squared value in `result`.
5. Sort the `result` array using `Arrays.sort()`.
6. Return the sorted `result` array.

## Complexity

- **Time:** `O(n log n)`
- **Space:** `O(n)`

## Notes

1. First square every element.
2. Store all squared values in a new array.
3. Use `Arrays.sort()` to arrange the squares in ascending order.
4. Negative numbers become positive after squaring.
5. Main pattern: **Array + Sorting**
6. **Spot It Instantly:** If the problem asks to square all elements and return them sorted → think **Square → Sort**.

## Important Code

```java
int[] result = new int[nums.length];

for (int i = 0; i < nums.length; i++) {
    int arr = nums[i] * nums[i];
    result[i] = arr;
}

Arrays.sort(result);

return result;
