// 17 ms | 42.8 MB

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            int len = r - l - 1;

            if (len > maxLen) {
                maxLen = len;
                start = l + 1;
            }

            // Even length palindrome
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            len = r - l - 1;

            if (len > maxLen) {
                maxLen = len;
                start = l + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }
}