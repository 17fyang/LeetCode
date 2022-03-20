package weekMatch.double_week.d46;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/20 22:20
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        int[][] arr = new int[2][];
        arr[0] = new int[]{1, -1, -1};
        arr[1] = new int[]{3, -2, 0};

        int[] nums = new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0};
        System.out.println(new Q02().canChoose(arr, nums));
    }

    public boolean canChoose(int[][] groups, int[] nums) {

        int location = 0;

        for (int i = 0; i < groups.length; i++) {

            boolean finish = false;
            while (location + groups[i].length <= nums.length) {
                int j;
                int start = location;
                for (j = 0; j < groups[i].length; j++) {
                    if (nums[start] != groups[i][j]) {
                        break;
                    } else {
                        start++;
                    }
                }

                finish = (j == groups[i].length);

                if (finish) {
                    location = start;
                    break;
                } else {
                    location++;
                }
            }

            if (!finish) return false;
        }
        return true;
    }
}
