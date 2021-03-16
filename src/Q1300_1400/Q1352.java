package Q1300_1400;

import java.util.ArrayList;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/9 15:42
 * @Description:
 */
public class Q1352 {
    private ArrayList<Integer> sum;

    public Q1352() {
        sum = new ArrayList<>();
        sum.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            sum = new ArrayList<>();
            sum.add(1);
        } else
            sum.add(sum.get(sum.size() - 1) * num);
    }

    public int getProduct(int k) {
        if (k >= sum.size()) return 0;
        return sum.get(sum.size() - 1) / sum.get(sum.size() - k - 1);
    }
}
