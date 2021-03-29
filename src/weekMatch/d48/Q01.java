package weekMatch.d48;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/20 22:23
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public int secondHighest(String s) {
        char[] arr = s.toCharArray();
        TreeSet<Integer> set = new TreeSet<>((c1, c2) -> c2 - c1);
        for (char c : arr) {
            if (c >= '0' && c <= '9') {
                set.add(c - '0');
            }
        }
        if (set.size() < 2) return -1;
        Iterator<Integer> it = set.iterator();
        it.next();
        return it.next();
    }
}
