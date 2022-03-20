package weekMatch.week.w231;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/7 10:28
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {

    }

    public int minChanges(int[] nums, int k) {
        if (k == 1) {
            int count = 0;
            for (int i : nums) count += (i == 0 ? 0 : 1);
            return count;
        }

        int res = 0;

        int totals[] = new int[k];
        TreeSet<Map.Entry<Integer, Integer>>[] sortSets = new TreeSet[k];

        for (int i = 0; i < k; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int total = 0;
            for (int j = i; j < nums.length; j += k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                total++;
            }

            totals[i] = total;
            TreeSet<Map.Entry<Integer, Integer>> sortSet = new TreeSet<>((e1, e2) -> e1.getValue() - e2.getValue());
            sortSet.addAll(map.entrySet());
            sortSets[i] = sortSet;

            int max = Integer.MIN_VALUE;
            for (int t : map.values()) {
                max = Math.max(t, max);
            }
            res += (total - max);
        }


        return res;
    }
}
