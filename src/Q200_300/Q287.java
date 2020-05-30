package Q200_300;

import java.util.Arrays;

/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

 */
public class Q287 {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) return last;
            last = nums[i];
        }
        return 0;
    }
}
