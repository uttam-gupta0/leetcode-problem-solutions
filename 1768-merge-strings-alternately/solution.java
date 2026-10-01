// 4 ms | 44.1 MB
class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";

        // Loop runs till both strings are fully traversed
        for (int i = 0; i < word1.length() || i < word2.length(); i++) {
            // If current index exists in first string
            if (i < word1.length())
                res += word1.charAt(i);

            // If current index exists in second string
            if (i < word2.length())
                res += word2.charAt(i);
        }
        return res;
    }
}