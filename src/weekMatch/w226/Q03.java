package weekMatch.w226;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/31 11:01
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[] candy = new int[]{5215, 14414, 67303, 93431, 44959, 34974, 22935, 64205, 28863, 3436, 45640, 34940, 38519, 5705, 14594, 30510, 4418, 87954, 8423, 65872, 79062, 83736, 47851, 64523, 15639, 19173, 88996, 97578, 1106, 17767, 63298, 8620, 67281, 76666, 50386, 97303, 26476, 95239, 21967, 31606, 3943, 33752, 29634, 35981, 42216, 88584, 2774, 3839, 81067, 59193, 225, 8289, 9295, 9268, 4762, 2276, 7641, 3542, 3415, 1372, 5538, 878, 5051, 7631, 1394, 5372, 2384, 2050, 6766, 3616, 7181, 7605, 3718, 8498, 7065, 1369, 1967, 2781, 7598, 6562, 7150, 8132, 1276, 6656, 1868, 8584, 9442, 8762, 6210, 6963, 4068, 1605, 2780, 556, 6825, 4961, 4041, 4923, 8660, 4114};
        int[][] query = new int[1][];
        query[0] = new int[]{91, 244597, 840227137};
        System.out.println(Arrays.toString(new Q03().canEat(candy, query)));
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] request = new long[candiesCount.length + 1];
        for (int i = 0; i < candiesCount.length; i++) {
            request[i + 1] = request[i] + candiesCount[i];
        }

        boolean[] resultFlag = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            long day = queries[i][1];
            long cap = queries[i][2];

            long minReq = request[type] + 1;
            long maxReq = request[type + 1];

            long minEat = day + 1;
            long maxEat = (day + 1) * cap;

            if (minEat <= maxReq && maxEat >= minReq) resultFlag[i] = true;
        }
        return resultFlag;
    }
}
