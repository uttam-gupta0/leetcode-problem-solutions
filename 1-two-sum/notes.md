# Approach
1. Create a `HashMap` to store:
   - **Key** → array value
   - **Value** → index of that value

2. Traverse the array using a `for` loop.

3. For every element, calculate:

   `needed = target - nums[i]`

4. Check whether `needed` already exists in the HashMap.

5. If it exists:
   - We found the two numbers.
   - Return their indices.

6. If it does not exist:
   - Store the current number and its index in the HashMap.

7. If no pair is found, return an empty array.

# Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(n)`

# Notes

- HashMap allows us to search for the required number quickly.
- Main formula:

  `needed = target - current`

- Important check:

  `map.containsKey(needed)`

- If the needed number is found:

  `return new int[]{map.get(needed), i};`

- Store the current number **after checking** for the needed number.
- This prevents using the same element twice.

# Example

```text
nums = [2, 7, 11, 15]
target = 9
