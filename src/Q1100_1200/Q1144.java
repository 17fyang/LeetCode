package Q1100_1200;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/30 22:11
 * @Description:
 */
public class Q1144 {

    public int movesToMakeZigzag(int[] nums) {
        int times = 0;

        for (int i = 0; i < nums.length; i += 2) {
            int min = Integer.MAX_VALUE;
            if (i - 1 >= 0) min = nums[i - 1];
            if (i + 1 < nums.length && nums[i + 1] < min) min = nums[i + 1];

            int rest = nums[i] - min;

            if (rest >= 0) times += (rest + 1);

        }
        return times;

    }


}
