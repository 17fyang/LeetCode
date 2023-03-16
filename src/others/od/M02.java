package others.od;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/24 14:14
 */
public class M02 {
    public static void main(String[] args) {
//        System.out.println(solution(""));
//        System.out.println(solution("a"));
//        System.out.println(solution("aaaaaaa"));
//        System.out.println(solution("abcba"));
//        System.out.println(solution("xxabcba"));
//        System.out.println(solution("abcbaxx"));
        System.out.println(solution("xxabcbapl"));
    }

    private static long solution(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int level = 0; level < len; level++) {
            for (int item = 0; item < len - level; item++) {
                int start = item;
                int end = item + level;

                if (start == end) {
                    dp[start][end] = true;
                } else if (start + 1 == end) {
                    dp[start][end] = arr[start] == arr[end];
                } else {
                    dp[start][end] = arr[start] == arr[end] && dp[start + 1][end - 1];
                }

                if (dp[start][end]) {
                    max = Math.max(max, end - start + 1);
                }
            }
        }
        return max;
    }
}
