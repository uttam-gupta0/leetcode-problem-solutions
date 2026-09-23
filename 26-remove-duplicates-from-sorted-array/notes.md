# Remove Duplicates from Sorted Array

## Problem

Remove duplicates from a **sorted array** in-place so that each element appears only once.

Return the number `k` of unique elements.

---

## Approach

Use the **Two Pointer** technique.

1. Since the array is already **sorted**, duplicate elements will always be next to each other.

2. Set:
   - `k = 1` → position where the next unique element will be stored.
   - `i = 1` → scans the array.

3. Compare the current element with the previous element:
```java
   nums[i] != nums[i - 1]
```

4. If they are different:
   - The current element is unique.
   - Store it at index `k`.
   - Increase `k`.

```java
   nums[k] = nums[i];
   k++;
```

5. If they are equal:
   - The current element is a duplicate.
   - Skip it.

6. Finally, return `k`.

---

## Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Notes

- Main pattern: Two Pointers
- The array must be sorted.
- `i` is the scanner pointer.
- `k` is the writer pointer.
- The first element is always unique.
- Therefore:

```java
  int k = 1;
```

- Compare:

```java
  nums[i] != nums[i - 1]
```

- If unique:

```java
  nums[k] = nums[i];
  k++;
```

- If duplicate → simply skip it.
- Return `k`, not the modified array.
- The problem requires in-place modification.
