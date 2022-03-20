package weekMatch.week.w234;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/28 10:28
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        System.out.println(new Q01().numDifferentIntegers("a123bc34d8ef34"));
    }

    public int numDifferentIntegers(String word) {
        String[] arr = word.split("([^0-9])+");
        Set<BigInteger> set = new HashSet<>();
        for (String s : arr) {
            if (s.equals("")) continue;
            set.add(new BigInteger(s));
        }
        return set.size();
    }

}
