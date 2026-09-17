# Container With Most Water

## Problem
Find two lines that together with the x-axis form a container that holds the **maximum amount of water**.

---

## Approach

Use the **Two Pointer** technique.

1. Set:
   - `left = 0`
   - `right = height.length - 1`

2. Calculate the height of the container:
   ```java
   int length = Math.min(height[left], height[right]);
3. Calculate the width:
   ```java
   int width = right - left;
4. Calculate the area:
   ```java
   int area = width * length;
5. Store the maximum area:
   ```java
   if (area > max) {
       max = area;
   }
6. Move the pointer having the smaller height:
   ```java
   if (height[left] < height[right]) {
       left++;
   }
   else {
       right--;
   }
7. Continue until `left >= right`.

## Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

## Notes

- Area formula:
  ```text
  Area = min(leftHeight, rightHeight) × (right - left)
1. The shorter line decides the water height.
2. Always move the pointer with the smaller height.
3. Moving the taller pointer cannot increase the area because the width becomes smaller while the shorter height still limits the container.
4. Main pattern: **Two Pointers**
