// 10 ms | 53 MB
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        char[] c = text1.toCharArray();
        char[] c1 = text2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c1.length; j++) {
                if(c[i] == c1[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}