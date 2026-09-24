# 4. Median of Two Sorted Arrays

[LeetCode Problem](https://leetcode.com/problems/median-of-two-sorted-arrays/)

## Approach

Use **Binary Search + Partition**.

The main idea is to divide both sorted arrays into a **left half** and a **right half**.

We want:

```text
All elements in Left Half ≤ All elements in Right Half
```

To achieve this efficiently:

1. Always perform binary search on the **smaller array**.
2. Choose a partition in the smaller array.
3. Calculate the corresponding partition in the larger array.
4. Check whether the partition is correct.
5. If correct, calculate the median.
6. Otherwise, move the binary search range.

---

## Code

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int half = (m + n + 1) / 2;

        while (left <= right) {

            // Partition of nums1
            int partition1 = (left + right) / 2;

            // Partition of nums2
            int partition2 = half - partition1;

            // Boundary values
            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd number of elements
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even number of elements
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            // nums1 partition is too far right
            else if (left1 > right2) {
                right = partition1 - 1;
            }

            // nums1 partition is too far left
            else {
                left = partition1 + 1;
            }
        }

        return 0.0;
    }
}
```

---

# Partition

Suppose:

```text
nums1 = [1, 3]
nums2 = [2, 4]
```

We want:

```text
[1, 2 | 3, 4]
```

The `|` represents the partition.

```text
Left Half  |  Right Half
-----------|------------
1, 2       | 3, 4
```

The important condition is:

```text
max(left side) <= min(right side)
```

For the two arrays:

```text
left1 <= right2
left2 <= right1
```

---

# Finding Partitions

```java
int partition1 = (left + right) / 2;

int partition2 = half - partition1;
```

Diagram:

```text
nums1:

[ ... left1 ... | ... right1 ... ]
                 ↑
             partition1


nums2:

[ ... left2 ... | ... right2 ... ]
                 ↑
             partition2
```

---

# Why `partition2`?

We need the left side to contain half of all elements.

```java
int half = (m + n + 1) / 2;
```

Therefore:

```java
partition2 = half - partition1;
```

Example:

```text
Total elements = 6
half = 3

If partition1 = 1

partition2 = 3 - 1
           = 2
```

So:

```text
nums1 → 1 element on left
nums2 → 2 elements on left

Total = 3 elements
```

---

# Boundary Conditions

What if the partition is at the beginning or end?

For example:

```text
nums1 = [1, 3]
```

If:

```text
partition1 = 0
```

There is nothing on the left.

So we use:

```java
Integer.MIN_VALUE
```

Similarly, if:

```text
partition1 = m
```

There is nothing on the right.

So we use:

```java
Integer.MAX_VALUE
```

Code:

```java
int left1 = (partition1 == 0)
        ? Integer.MIN_VALUE
        : nums1[partition1 - 1];

int right1 = (partition1 == m)
        ? Integer.MAX_VALUE
        : nums1[partition1];
```

The same logic is used for `nums2`.

---

# Check Correct Partition

We need:

```java
if (left1 <= right2 && left2 <= right1)
```

In simple words:

```text
Left side of nums1 ≤ Right side of nums2

AND

Left side of nums2 ≤ Right side of nums1
```

If both are true, we found the correct partition.

---

# If Partition Is Wrong

## Case 1: Move Left

If:

```java
left1 > right2
```

then we selected too many elements from `nums1`.

Move the partition to the left:

```java
right = partition1 - 1;
```

---

## Case 2: Move Right

If:

```java
left2 > right1
```

then we selected too few elements from `nums1`.

Move the partition to the right:

```java
left = partition1 + 1;
```

---

# Calculate Median

## Odd Number of Elements

Example:

```text
[1, 2, 3]
```

Median:

```text
2
```

After finding the correct partition:

```java
return Math.max(left1, left2);
```

Why?

The largest element on the left side is the middle element.

---

## Even Number of Elements

Example:

```text
[1, 2, 3, 4]
```

Median:

```text
(2 + 3) / 2
= 2.5
```

Code:

```java
return (Math.max(left1, left2)
        + Math.min(right1, right2)) / 2.0;
```

---

# Dry Run

Example:

```text
nums1 = [1, 3]
nums2 = [2, 4]
```

Total:

```text
m = 2
n = 2

half = (2 + 2 + 1) / 2
     = 2
```

Initial:

```text
left = 0
right = 2
```

### First Partition

```text
partition1 = (0 + 2) / 2
           = 1

partition2 = 2 - 1
           = 1
```

So:

```text
nums1 = [1 | 3]
nums2 = [2 | 4]
```

Values:

```text
left1  = 1
right1 = 3

left2  = 2
right2 = 4
```

Check:

```text
left1 <= right2

1 <= 4 ✓
```

```text
left2 <= right1

2 <= 3 ✓
```

Correct partition!

---

# Calculate Median

Total number of elements:

```text
4
```

Even.

Therefore:

```text
max(left1, left2)
= max(1, 2)
= 2
```

and:

```text
min(right1, right2)
= min(3, 4)
= 3
```

Median:

```text
(2 + 3) / 2
= 2.5
```

Answer:

```text
2.5
```

---

# Complexity

### Time Complexity

```text
O(log(min(m, n)))
```

Binary search is performed only on the smaller array.

### Space Complexity

```text
O(1)
```

No extra array is created.

---

# Key Pattern

```text
Two Sorted Arrays
        ↓
Binary Search on Smaller Array
        ↓
Find Partition
        ↓
Check:
left1 <= right2
left2 <= right1
        ↓
Correct Partition
        ↓
Calculate Median
```

---

# Spot It Instantly

If the problem says:

> Find the median of two sorted arrays

and requires:

```text
O(log(min(m, n)))
```

Think:

**Binary Search + Partition**

---

# Remember

> **Binary Search on the smaller array → Find correct partition → Check boundaries → Calculate median**
