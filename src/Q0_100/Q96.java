package Q0_100;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/31 11:16
 * @Description:
 */
public class Q96 {
    private static final int[] mapping = new int[20];

    static {
        mapping[0] = 1;
        mapping[1] = 1;
        mapping[2] = 2;
        mapping[3] = 5;
        for (int i = 4; i < mapping.length; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                value += mapping[j] * mapping[i - j - 1];
            }
            mapping[i] = value;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mapping));
    }

    public int numTrees(int n) {
        return mapping[n];
    }
}
