package Q0_100;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/14 23:08
 */
public class Q5 {
    public static void main(String[] args) {
        System.out.println(new Q5().longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();

        int len = arr.length;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = -1;
        int maxStart = 0;
        int maxEnd = 0;

        for (int level = 1; level < len; level++) {
            for (int item = 0; item < len - level; item++) {
                int i = item;
                int j = level + item;

                if (j == i + 1) {
                    dp[i][j] = arr[i] == arr[j];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j];
                }

                if (dp[i][j] && j - i > maxLen) {
                    maxLen = j - i;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
