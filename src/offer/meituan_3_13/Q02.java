package offer.meituan_3_13;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/13 15:52
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String[] arr = s.split("[a-z]");

        LinkedList<String> list = new LinkedList<>();
        for (String ss : arr) {
            if (ss.equals("")) continue;
            if (ss.startsWith("0")) {
                char[] charArr = ss.toCharArray();
                int i = 0;
                while (i < charArr.length && charArr[i] == '0') i++;
                if (i == charArr.length) ss = "0";
                else ss = String.valueOf(charArr, i, charArr.length - i);
            }
            list.add(ss);
        }

        list.sort((s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            else {
                char[] c1 = s1.toCharArray();
                char[] c2 = s2.toCharArray();
                for (int i = 0; i < c1.length; i++) {
                    if (c1[i] - c2[i] != 0) return c1[i] - c2[i];
                }
                return 0;
            }
        });

        for (String i : list) {
            System.out.println(i);
        }
    }
}
