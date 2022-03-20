package weekMatch.week.w228;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/15 10:37
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        System.out.println(new Q01().minOperations("10010100"));
    }

    public int minOperations(String s) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = Arrays.copyOf(arr1, arr1.length);

        int[] dp1 = new int[arr1.length];
        int[] dp2 = new int[arr1.length];

        arr2[0] = arr2[0] == '0' ? '1' : '0';
        dp2[0] = 1;

        for (int i = 1; i < dp1.length; i++) {
            if (arr1[i] != arr1[i - 1]) {
                dp1[i] = dp1[i - 1];
            } else {
                arr1[i] = (arr1[i] == '0' ? '1' : '0');
                dp1[i] = dp1[i - 1] + 1;
            }

            if (arr2[i] != arr2[i - 1]) {
                dp2[i] = dp2[i - 1];
            } else {
                arr2[i] = (arr2[i] == '0' ? '1' : '0');
                dp2[i] = dp2[i - 1] + 1;
            }
        }
        return Math.min(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}
