package Q100_200;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/17 11:28
 * @Description:
 */
public class Q115 {
    public static void main(String[] args) {
        System.out.println(new Q115().numDistinct("", "a"));
    }

    public int numDistinct(String s, String t) {
        char[] str = s.toCharArray();
        char[] word = t.toCharArray();
        if (str.length < word.length) return 0;
        if (str.length == word.length) return s.equals(t) ? 1 : 0;

        int[][] dp = new int[str.length][word.length];

        if (str[0] == word[0]) dp[0][0] = 1;

        for (int i = 1; i < str.length; i++) {
            dp[i][0] = (str[i] == word[0] ? dp[i - 1][0] + 1 : dp[i - 1][0]);

            for (int j = 1; j < word.length; j++) {
                if (str[i] == word[j]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[str.length - 1][word.length - 1];
    }

}
