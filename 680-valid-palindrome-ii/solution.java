// 5 ms | 47.4 MB
class Solution {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            if (arr[left] != arr[right]) {

                // Delete left character OR delete right character
                return isPalindrome(arr, left + 1, right)
                    || isPalindrome(arr, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome(char[] arr, int left, int right) {

        while (left < right) {

            if (arr[left] != arr[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}