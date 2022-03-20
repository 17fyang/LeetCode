package weekMatch.week.w227;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/7 10:29
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {

    }

    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);

        if (arr[2] >= (arr[0] + arr[1])) return arr[0] + arr[1];

        return (arr[0] + arr[1] + arr[2]) / 2;
    }
}
