package Q0_100;

import java.util.Stack;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/15 13:32
 * @Description:
 */
public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.peek().equals('(')) stack.pop();
                else if (c == ']' && stack.peek().equals('[')) stack.pop();
                else if (c == '}' && stack.peek().equals('{')) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
