package Q900_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/8/30 23:25
 */
public class Q967 {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            List<Integer> single = new ArrayList<>();
            dp(i, n, k, single);
            list.addAll(single);
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }

    private void dp(int num, int n, int k, List<Integer> list) {
        if (n <= 1) {
            list.add(num);
            return;
        }

        int tail = num % 10;

        if (k == 0) {
            dp(num * 10 + tail, n - 1, k, list);
            return;
        }
        if (tail + k < 10) {
            dp(num * 10 + tail + k, n - 1, k, list);
        }
        if (tail - k >= 0) {
            dp(num * 10 + tail - k, n - 1, k, list);
        }
    }

    private int upper(int start, int n, int k) {
        if (start + k >= 10) {
            return -1;
        }

        int result = start;
        for (int i = 1; i < n; i++) {
            result = (i % 2 == 1) ? (result * 10 + k + start) : (result * 10 + start);
        }
        return result;
    }

    private int down(int start, int n, int k) {
        if (start - k < 0) {
            return -1;
        }

        int result = start;
        for (int i = 1; i < n; i++) {
            result = (i % 2 == 1) ? (result * 10 + start - k) : (result * 10 + start);
        }
        return result;
    }
}
