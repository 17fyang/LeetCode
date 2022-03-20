package weekMatch.week.w235;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/21 13:55
 * @Description:
 */
public class Q02 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] arr : logs) {
            Set<Integer> set = map.getOrDefault(arr[0], new HashSet<>());

            set.add(arr[1]);
            map.put(arr[0], set);
        }

        int[] result = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() <= k) result[entry.getValue().size() - 1]++;
        }

        return result;
    }
}
