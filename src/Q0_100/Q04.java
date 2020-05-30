package Q0_100;

/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Q04 {
    public static void main(String[] args) {
        int nums1[] = {0, 0, 0, 0, 0};
        int nums2[] = {};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int mid = length / 2;
        int i = 0;
        int j = 0;
        int precent = 0;
        int last = 0;
        while ((i + j) <= mid) {
            last = precent;
            if (i >= nums1.length) {
                precent = nums2[j];
                j++;
                continue;
            }
            if (j >= nums2.length) {
                precent = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                precent = nums1[i];
                i++;
            } else {
                precent = nums2[j];
                j++;
            }
        }
        if (length % 2 == 0) return (last + precent) * 1.0 / 2;
        else return precent;
    }
}
