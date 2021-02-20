package weekMatch.d45;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/6 22:18
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) sum += entry.getKey();
        }
        return sum;
    }
}
