package weekMatch.double_week.d47;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/6 22:25
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        System.out.println(new Q03().beautySum("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef"));
    }

    public int beautySum(String s) {
        char[] arr = s.toCharArray();

        int[] result = new int[arr.length];

        for (int i = 2; i < result.length; i++) {
            int sum = 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put(arr[i], 1);
            map.put(arr[i - 1], map.getOrDefault(arr[i - 1], 0) + 1);
            int max = 0;
            int min = 0;
            int minNum = 0;
            boolean flag = false;
            if (arr[i] == arr[i - 1]) {
                max = min = minNum = 2;
                flag = true;
            } else {
                max = min = 1;
                minNum = 2;
            }

            for (int j = i - 2; j >= 0; j--) {
                int time = map.getOrDefault(arr[j], 0) + 1;
                map.put(arr[j], time);
                if (flag && time <= max) flag = false;
                if (time > max) {
                    max++;
                    if (flag) {
                        min++;
                        minNum++;
                    }
                }
                if (time == min + 1) {
                    if (minNum == 1) {
                        min = time;
                        minNum = reMin(map, min);
                    } else {
                        minNum--;
                    }
                } else if (time == min) {
                    minNum++;
                } else if (time < min) {
                    min = time;
                    minNum = 1;
                }
                sum += (max - min);
            }
            result[i] = result[i - 1] + sum;
        }
        return result[result.length - 1];
    }

    private int reMin(Map<Character, Integer> map, int min) {
        int count = 0;
        for (int i : map.values()) {
            if (i == min) count++;
        }
        return count;
    }
}
