package weekMatch.w226;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/31 10:28
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {


    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            char[] arr = String.valueOf(i).toCharArray();
            int result = 0;
            for (char c : arr) {
                result += (c - 48);
            }
            map.put(result, map.getOrDefault(result, 0) + 1);

        }

        int max = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) max = entry.getValue();
        }
        return max;
    }
}
