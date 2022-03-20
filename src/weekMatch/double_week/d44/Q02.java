package weekMatch.double_week.d44;

import java.util.*;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/23 22:53
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        int[][] lan = new int[4][];
        lan[0] = new int[]{2};
        lan[1] = new int[]{1, 3};
        lan[2] = new int[]{1, 2};
        lan[3] = new int[]{3};

        int[][] relation = new int[4][];
        relation[0] = new int[]{1, 4};
        relation[1] = new int[]{1, 2};
        relation[2] = new int[]{3, 4};
        relation[3] = new int[]{2, 3};
        System.out.println(new Q02().minimumTeachings(3, lan, relation));

    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer>[] skillSet = new Set[languages.length];
        for (int i = 0; i < skillSet.length; i++) {
            skillSet[i] = new HashSet<>();
            for (int j : languages[i]) skillSet[i].add(j);
        }

        List<int[]> needList = new LinkedList<>();
        for (int[] relation : friendships) {
            Set<Integer> skill2 = skillSet[relation[1] - 1];
            boolean flag = false;
            for (int value1 : skillSet[relation[0] - 1]) {
                if (skill2.contains(value1)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) needList.add(relation);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int times = 0;
            Set<Integer> teachSet = new HashSet<>();
            for (int[] relation : needList) {
                boolean teachFlag1 = teachSet.contains(relation[0] - 1);
                boolean teachFlag2 = teachSet.contains(relation[1] - 1);
                if (!skillSet[relation[0] - 1].contains(i) && !teachFlag1) {
                    times++;
                    teachSet.add(relation[0] - 1);
                }

                if (!skillSet[relation[1] - 1].contains(i) && !teachFlag2) {
                    times++;
                    teachSet.add(relation[1] - 1);
                }
            }
            min = Math.min(times, min);
        }

        return min;

    }

}
