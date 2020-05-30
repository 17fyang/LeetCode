package Q1200_1300;

/**
 * ClassName: Q1283
 * Description:
 * 给你一个整数数组 nums 和一个正整数 threshold  ，
 * 你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 * <p>
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 * date: 2020/5/30 22:31
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class Q1283 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(new Q1283().smallestDivisor(arr, threshold));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] > max) max = nums[i];


        int left = 1;
        int right = max;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (check(nums, threshold, mid)) right = mid;
            else left = mid;
        }
        for (int i = left; i <= right; i++)
            if (check(nums, threshold, i)) return i;
        return 0;
    }

    private boolean check(int nums[], int threshold, int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % mid == 0) sum += nums[i] / mid;
            else sum += nums[i] / mid + 1;
        }
        if (sum <= threshold) return true;
        return false;
    }
}
