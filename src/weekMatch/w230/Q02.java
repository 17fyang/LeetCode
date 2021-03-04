package weekMatch.w230;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/28 10:27
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        int[] base = new int[]{3, 10};
        int[] topCost = new int[]{2, 5};
        System.out.println(new Q02().closestCost(base, topCost, 9));
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int cost : baseCosts) {
            min = Math.min(min, cost);
            max = Math.max(max, cost);
        }
        if (min >= target) return min;

        int total = max;
        for (int top : toppingCosts) {
            total += top * 2;
        }
        if (total <= target) return total;


        int close = Integer.MAX_VALUE;
        int closeValue = 0;
        Map<Integer, Object> topMap = new TreeMap<>();
        Object o = new Object();
        topMap.put(0, o);

        for (int top : toppingCosts) {
            Map<Integer, Object> newMap = new HashMap<>();
            for (Map.Entry<Integer, Object> entry : topMap.entrySet()) {
                if (entry.getKey() + top > 10000) continue;
                newMap.put(top, o);
                newMap.put(entry.getKey() + top, o);
                newMap.put(entry.getKey() + top * 2, o);
            }
            topMap.putAll(newMap);
            if (topMap.isEmpty()) {
                topMap.put(top, o);
                topMap.put(top * 2, o);
            }
        }


        for (int base : baseCosts) {
            if (topMap.get(target - base) != null) return target;
        }

        for (int base : baseCosts) {
            for (int key : topMap.keySet()) {
                int abs = Math.abs(target - key - base);

                if (abs == close) {
                    closeValue = Math.min(closeValue, key + base);
                } else if (abs < close) {
                    close = abs;
                    closeValue = key + base;
                }
            }
        }


        return closeValue;

    }
}
