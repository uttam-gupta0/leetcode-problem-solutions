# Approach: Use Two Pointers

Think about using a `StringBuilder` and a pointer to track the positions in `spaces`.

## Steps

1. Create an empty `StringBuilder` to store the result.
2. Traverse the string `s` character by character using a `for` loop.
3. Before adding each character, check whether the current index `i` matches the next position in `spaces[j]`.
4. If the positions match, append a space (`' '`) to the `StringBuilder`.
5. Append the current character using `s.charAt(i)`.
6. Increment `j` whenever a space is inserted, so it points to the next position in the `spaces` array.
7. Check `j < spaces.length` before accessing `spaces[j]` to avoid an `ArrayIndexOutOfBoundsException`.
8. Convert the `StringBuilder` to a string using `toString()` and return the result.

## Two-Pointer Logic

- `i` — tracks the current character in the string `s`.
- `j` — tracks the next position in the `spaces` array.

**Condition:** If `i == spaces[j]`, insert a space before the current character and increment `j`.

## Complexity Analysis

- **Time Complexity:** `O(n + m)`, where `n` is the length of `s` and `m` is the length of `spaces`.
- **Space Complexity:** `O(n + m)` for the resulting string and its builder.

## Key Takeaway

Use two pointers to traverse the string and space positions efficiently without creating multiple intermediate strings.
