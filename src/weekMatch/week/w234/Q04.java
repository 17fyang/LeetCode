package weekMatch.week.w234;

import java.math.BigDecimal;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/28 10:28
 * @Description:
 */
public class Q04 {
    public static final BigDecimal big = new BigDecimal(1000000007);

    public static void main(String[] args) {
        System.out.println(new Q04().maxNiceDivisors(545918790));
    }

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors < 5) return primeFactors;


        int mod = primeFactors % 3;
        BigDecimal chu = new BigDecimal(3);
        if (mod == 0) return chu.pow(primeFactors / 3).divideAndRemainder(big)[1].intValue();
        else if (mod == 1)
            return chu.pow(primeFactors / 3 - 1).multiply(new BigDecimal(4)).divideAndRemainder(big)[1].intValue();
        else return chu.pow(primeFactors / 3).multiply(new BigDecimal(2)).divideAndRemainder(big)[1].intValue();
    }
}
