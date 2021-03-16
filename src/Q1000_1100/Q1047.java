package Q1000_1100;


import java.util.Stack;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/9 15:35
 * @Description:
 */
public class Q1047 {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
