package weekMatch.week.w222;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/3 11:08
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 7, 15, 31, 63, 127, 255, 511};
        System.out.println(new Q02().countPairs(arr));
    }

    public int countPairs(int[] deliciousness) {
        int[] targetArr = new int[21];
        for (int i = 0; i < 21; i++) targetArr[i] = (int) Math.pow(2, i);

        long total = 0;
        Map<Integer, Integer> foodMap = new HashMap<>();
        for (int food : deliciousness) {
            for (int target : targetArr) {
                int aimFood = target - food;
                if (foodMap.containsKey(aimFood)) {
                    total += foodMap.get(aimFood);
                }
            }
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
        }
        System.out.println((int) (Math.pow(10, 9) + 7));
        return (int) (total % 1000000007);
    }
}
