package weekMatch.week.w243;

import java.math.BigInteger;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/30 10:07
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] arr1 = firstWord.toCharArray();
        char[] arr2 = secondWord.toCharArray();
        char[] targetArr = targetWord.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char value : arr1) sb.append(value - 'a');
        BigInteger bigInteger1 = new BigInteger(sb.toString());

        sb = new StringBuilder();
        for (char c : arr2) sb.append(c - 'a');
        BigInteger bigInteger2 = new BigInteger(sb.toString());

        sb = new StringBuilder();
        for (char c : targetArr) sb.append(c - 'a');
        BigInteger bigTarget = new BigInteger(sb.toString());

        return bigInteger1.add(bigInteger2).toString().equals(bigTarget.toString());
    }

}
