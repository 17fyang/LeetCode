package weekMatch.others.day6_19;

import java.util.*;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/6/19 21:54
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 13, 7, 11, 1, 5, 5, 3};
        System.out.println(new Q02().halfQuestions(arr));
    }

    public int halfQuestions(int[] questions) {
        int perNum = questions.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int value : questions) {
            int time = map.getOrDefault(value, 0);
            map.put(value, time + 1);
        }

        List<Integer> queue = new ArrayList<>(map.values());
        Collections.sort(queue, (i1, i2) -> i2 - i1);

        int types = 0;
        int total = 0;
        for (int value : queue) {
            total += value;
            types++;
            if (total >= perNum) return types;
        }
        return 0;
    }
}
