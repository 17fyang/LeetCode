package weekMatch.w227;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/7 10:29
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public boolean check(int[] nums) {
        if (nums.length <= 1) return true;
        boolean flag = false;
        int maxStart = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (flag) return false;
                flag = true;
            }
        }

        if (!flag) return true;
        if (maxStart >= nums[nums.length - 1]) return true;

        return false;
    }
}
