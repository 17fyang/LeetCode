package Q1500_1600;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/10 14:50
 * @Description:
 */
public class Q1574 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 17, 21, 15, 15, 9, 17, 22, 22, 13};
        System.out.println(new Q1574().findLengthOfShortestSubarray(arr));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        if (arr == null || arr.length < 1) return 0;

        int res = Math.min(case1(arr), case3(arr));
        if (res == 0) return res;

        return Math.min(res, case2(arr));

    }

    private int case1(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) i--;
        return i + 1;
    }

    private int case2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (arr[left] <= arr[left + 1]) left++;
        while (arr[right] >= arr[right - 1]) right--;

        int interval = right - left;
        if (arr[right] >= arr[left]) return interval - 1;

        int temp = interval;
        while (temp < arr.length) {
            temp++;

            if (left - temp + interval < 0 || left + temp >= arr.length) return temp - 1;

            for (int i = 0; i <= temp - interval; i++) {
                if (arr[left - i] <= arr[left - i + temp]) return temp - 1;
            }

        }
        return arr.length;
    }

    private int case3(int[] arr) {
        int i = 0;
        while (i < arr.length - 1 && arr[i] <= arr[i + 1]) i++;
        return arr.length - i;
    }
}
