package Q1300_1400;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Q1399
 * Description:
 * date: 2020/5/30 14:28
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class Q1399 {
    public static void main(String[] args) {
        Q1399 q = new Q1399();
        System.out.println(q.countLargestGroup(1));
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            Integer num = map.get(sum);
            if (num == null) map.put(sum, 1);
            else {
                num++;
                if (num > max) max = num;
                map.put(sum, num);
            }
        }
        int num = 0;
        for (int i : map.values()) {
            if (i == max) num++;
        }
        return num;
    }

    private int getSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
