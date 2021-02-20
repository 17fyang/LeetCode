package weekMatch.w228;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/15 11:29
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(new Q03().minimumSize(arr, 1));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(num, max);
        int left = 0;
        int right = max;

        while (left < right) {
            int middle = (left + right) / 2;
            if (validate(nums, middle, maxOperations))
                right = middle - 1;
            else
                left = middle + 1;
        }

        for (int i = right; i <= left + 10; i++)
            if (validate(nums, i, maxOperations)) return i;
        return left;
    }

    private boolean validate(int[] nums, int code, int maxOperations) {
        int operationTime = 0;
        for (int num : nums) {
            operationTime += operaTimes(code, num);
            if (operationTime > maxOperations) {
                return false;
            }
        }
        return true;
    }


    private int operaTimes(int minNum, int num) {
        if (minNum == 0) return Integer.MAX_VALUE;
        return num % minNum == 0 ? (num / minNum) - 1 : num / minNum;
    }
}
