package weekMatch.week.w222;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/3 10:33
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        int[][] arr = new int[4][];
        arr[0] = new int[]{5, 10};
        arr[1] = new int[]{2, 5};
        arr[2] = new int[]{4, 7};
        arr[3] = new int[]{3, 9};
        System.out.println(new Q01().maximumUnits(arr, 10));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a1, a2) -> a2[1] - a1[1]);
        int total = 0;
        int size = 0;
        for (int[] box : boxTypes) {
            if (size + box[0] >= truckSize) {
                total += box[1] * (truckSize - size);
                return total;
            } else {
                total += box[1] * box[0];
                size += box[0];
            }
        }
        return total;
    }
}
