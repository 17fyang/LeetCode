package weekMatch.week.w225;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/24 11:08
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[][] arr = new int[2][];
        arr[0] = new int[]{5, 2};
        arr[1] = new int[]{1, 6};
        System.out.println(new Q03().kthLargestValue(arr, 4));
    }

    public int kthLargestValue(int[][] matrix, int k) {
        Map<Integer, Integer> map = new TreeMap<>((x1, x2) -> x2 - x1);

        int[][] result = new int[matrix.length][matrix[0].length];
        result[0][0] = matrix[0][0];
        map.put(result[0][0], 1);
        for (int i = 1; i < matrix.length; i++) {
            result[i][0] = result[i - 1][0] ^ matrix[i][0];
            map.put(result[i][0], map.getOrDefault(result[i][0], 0) + 1);
        }
        for (int i = 1; i < matrix[0].length; i++) {
            result[0][i] = result[0][i - 1] ^ matrix[0][i];
            map.put(result[0][i], map.getOrDefault(result[0][i], 0) + 1);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] ^ result[i][j - 1] ^ result[i - 1][j] ^ result[i - 1][j - 1];
                map.put(result[i][j], map.getOrDefault(result[i][j], 0) + 1);
            }
        }

        int num = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            num += entry.getValue();
            if (num >= k) return entry.getKey();
        }
        return 0;
    }
}
