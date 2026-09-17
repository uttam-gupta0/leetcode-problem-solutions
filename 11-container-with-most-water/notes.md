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
````

3. Calculate the width:
   int width = right - left;
   ```
4. Calculate the area:
   int area = width * length;
   ```
5.  Store the maximum area. 
6.  Move the pointer having the **smaller height**: 
   -  If `height[left] < height[right]` → `left++` 
   -  Otherwise → `right--` 
7.  Continue until `left >= right`. 

---

## Important Code
int length = Math.min(height[left], height[right]);

int width = right - left;

int area = width * length;

if (area > max) {
    max = area;
}

if (height[left] < height[right]) {
    left++;
}
else {
    right--;
}
```

---

## Complexity

- **Time:** `O(n)` 
- **Space:** `O(1)` 

---

## Notes

- Area formula:
  Area = min(leftHeight, rightHeight) × (right - left)
  ```
-  The **shorter line decides the water height**. 
-  Always move the pointer with the **smaller height**. 
-  Moving the taller pointer cannot increase the area because the width becomes smaller while the shorter height still limits the container. 
-  Main pattern: **Two Pointers** 
- **Spot It Instantly:** If the problem asks for maximum area between two positions/lines → think **Two Pointers**.

