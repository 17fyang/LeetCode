package Q500_600;

import java.util.Stack;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/6 14:10
 * @Description:
 */
public class Q503 {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int lastIndex = stack.pop();
                result[lastIndex] = nums[i];
            }
            stack.push(i);
        }

        for (int num : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int lastIndex = stack.pop();
                result[lastIndex] = num;
            }
        }

        for (int index : stack) {
            result[index] = -1;
        }

        return result;
    }
}
