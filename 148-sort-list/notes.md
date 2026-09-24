# Approach

Use **Merge Sort** on the linked list.

### Steps

1. **Base Case**
   - If the list has `0` or `1` node, it is already sorted.

2. **Find the Middle**
   - Use the **Slow and Fast Pointer** technique.
   - `slow` moves one step.
   - `fast` moves two steps.
   - When `fast` reaches the end, `slow` is near the middle.

3. **Split the List**
   - Store `slow.next` as `mid`.
   - Set `slow.next = null` to divide the list into two halves.

4. **Recursively Sort Both Halves**
   - Sort the left half.
   - Sort the right half.

5. **Merge**
   - Merge the two sorted linked lists.
   - Use a `dummy` node to make merging easier.

6. **Return the Sorted List**
   - Return `dummy.next`.

---

# Complexity

### Time Complexity

**O(n log n)**

- The list is divided into approximately half each time.
- There are `log n` levels.
- Merging at each level takes `O(n)`.

Therefore:

`O(n log n)`

### Space Complexity

**O(log n)**

- Recursion stack requires `O(log n)` space.
- No extra array is used.

---

# Notes

- **Pattern:** Merge Sort + Fast & Slow Pointer
- Linked lists are well suited for **Merge Sort** because merging can be done without shifting elements.
- `slow` finds the middle.
- `fast` moves twice as fast as `slow`.
- `slow.next = null` splits the linked list.
- Recursion sorts both halves.
- `merge()` combines two sorted lists.
- A **dummy node** makes the merge operation easier.

### Spot It Instantly

If the problem asks:

> **Sort a linked list efficiently**

Think:

**Merge Sort → Find Middle → Split → Recursively Sort → Merge**

---

# Important Code Pattern

### Find Middle

```java
ListNode slow = head;
ListNode fast = head.next;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

### Split

```java
ListNode mid = slow.next;
slow.next = null;
```

### Recursive Sort

```java
ListNode left = sortList(head);
ListNode right = sortList(mid);
```

### Merge

```java
return merge(left, right);
```
