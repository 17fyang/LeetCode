package Q200_300;

import java.util.Stack;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/11 11:21
 * @Description:
 */
public class Q227 {
    public static void main(String[] args) {
        System.out.println(new Q227().calculate(" 3+5 / 2 "));
    }

    public int calculate(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int[] readRes;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case ' ':
                    break;
                case '*':
                    int top = stack.pop();
                    readRes = readInt(arr, i + 1);
                    i = readRes[1];
                    stack.push(readRes[0] * top);
                    break;
                case '/':
                    readRes = readInt(arr, i + 1);
                    i = readRes[1];
                    stack.push(stack.pop() / readRes[0]);
                    break;
                default:
                    readRes = readInt(arr, i);
                    i = readRes[1];
                    stack.push(readRes[0] * sign);
            }
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }

    private int[] readInt(char[] arr, int index) {
        int i = index;
        while (arr[i] == ' ') i++;
        int temp = 0;
        while (i < arr.length && Character.isDigit(arr[i])) {
            temp = temp * 10 + arr[i] - '0';
            i++;
        }
        i--;
        return new int[]{temp, i};
    }
}
