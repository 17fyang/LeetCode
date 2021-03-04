package weekMatch.w230;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/28 10:27
 * @Description:
 */
public class Q03 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || nums1.length * 6 < nums2.length) return -1;


        int[] arr1 = new int[7];
        int[] arr2 = new int[7];
        int sum1 = 0;
        int sum2 = 0;


        for (int i : nums1) {
            sum1 += i;
            arr1[i]++;
        }
        for (int i : nums2) {
            sum2 += i;
            arr2[i]++;
        }

        if (sum1 < sum2) {
            int temp = sum1;
            sum1 = sum2;
            sum2 = temp;
            int[] t = arr1;
            arr1 = arr2;
            arr2 = t;
        }

        int time = 0;
        int location = 1;
        while (sum1 > sum2) {
            if (arr1[7 - location] != 0) {
                arr1[7 - location]--;
                sum1 -= (6 - location);
                time++;
            } else if (arr2[location] != 0) {
                arr2[location]--;
                sum2 += (6 - location);
                time++;
            } else {
                location++;
            }
        }
        return time;
    }
}
