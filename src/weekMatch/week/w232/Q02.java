package weekMatch.week.w232;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/14 10:36
 * @Description:
 */
public class Q02 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = edges.length;
        for (int i = 0; i < n; i++) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) return entry.getKey();
        }
        return -1;

    }
}
