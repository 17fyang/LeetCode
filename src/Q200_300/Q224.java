package Q200_300;

import java.util.Stack;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/10 11:21
 * @Description:
 */
public class Q224 {
    public static void main(String[] args) {
        System.out.println(new Q224().calculate(" 2-1 + 2 "));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        String ex = s;
        for (int i = 0; i < ex.length(); i++) {
            if (ex.charAt(i) == '(') {
                stack.push(i);
            } else if (ex.charAt(i) == ')') {
                int start = stack.pop();
                long tempRes = simpleCal(ex, start + 1, i);
                ex = ex.substring(0, start) + tempRes + ex.substring(i + 1);
                i = start;
            }
        }
        return (int) simpleCal(ex, 0, ex.length());
    }

    private long simpleCal(String s, int start, int end) {
        char[] arr = s.toCharArray();
        long result = 0;
        int sign = 1;
        boolean flag = false;
        for (int i = start; i < end; ++i) {
            switch (arr[i]) {
                case '+':
                    if (flag) sign = 1;
                    flag = false;
                    break;
                case '-':
                    if (flag) sign = -1;
                    else sign = -sign;
                    flag = false;
                    break;
                case ' ':
                    break;
                default:
                    flag = true;
                    long temp = 0;
                    while (i < end && Character.isDigit(arr[i])) {

                        temp = temp * 10 + arr[i] - '0';
                        i++;
                    }
                    if (i != end) --i;
                    result += sign * temp;
            }
        }
        return result;
    }
}
