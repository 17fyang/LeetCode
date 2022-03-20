package weekMatch.week.w229;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/21 10:54
 * @Description:
 */
public class Q04 {


    public int longestPalindrome(String word1, String word2) {
        String word = word1 + word2;

        int leftLen = word1.length();
        int rightLen = leftLen + word2.length();


        int n = word.length();
        int[][] dp = new int[n][n];
        boolean[][] flag = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < leftLen && j >= leftLen) flag[i][j] = true;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                if (flag[i][j] && dp[i][j] > max) max = dp[i][j];
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;

    }

    public int longestPalindromeSubseq(String word) {
        int n = word.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}
