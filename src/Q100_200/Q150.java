package Q100_200;

import java.util.Stack;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/20 16:48
 * @Description:
 */
public class Q150 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.length() == 1 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                int b = stack.pop();
                int a = stack.pop();
                System.out.println(a + " " + b);
                if (s.equals("+")) stack.push(a + b);
                else if (s.equals("-")) stack.push((a - b));
                else if (s.equals("*")) stack.push(a * b);
                else stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
