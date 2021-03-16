package Q1000_1100;

import publicUtil.DataUtil;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/12 14:06
 * @Description:
 */
public class Q1029 {
    public static void main(String[] args) {
        int[][] arr = DataUtil.parseDoubleIntArray("[[518,518],[71,971],[121,862],[967,607],[138,754],[513,337],[499,873],[337,387],[647,917],[76,417]]");
        System.out.println(new Q1029().twoCitySchedCost(arr));
    }

    public int twoCitySchedCost(int[][] costs) {
        TreeMap<Integer, Integer> aToB = new TreeMap<>();
        TreeMap<Integer, Integer> bToA = new TreeMap<>();

        int n = costs.length / 2;
        int aNum = 0;
        int noneNum = 0;
        int total = 0;
        for (int[] cost : costs) {
            int cha = cost[0] - cost[1];
            if (cha > 0) {
                bToA.put(cha, bToA.getOrDefault(cha, 0) + 1);
            } else if (cha < 0) {
                aNum++;
                aToB.put(-cha, aToB.getOrDefault(-cha, 0) + 1);
            } else {
                noneNum++;
            }
            total += Math.min(cost[0], cost[1]);
        }

        int more = aNum - n;
        TreeMap<Integer, Integer> map = more > 0 ? aToB : bToA;
        more = more > 0 ? more : -more - noneNum;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (more <= 0) return total;
            int num = more > entry.getValue() ? entry.getValue() : more;

            total += entry.getKey() * num;
            more -= num;
        }
        return total;

    }
}