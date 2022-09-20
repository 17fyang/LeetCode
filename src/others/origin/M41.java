package others.origin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: M41
 * Description:
 * date: 2020/5/30 21:32
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class M41 {
    List<Integer> list = new ArrayList<>();

    public M41() {

    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        if (list.isEmpty()) return 0;
        Collections.sort(list);
        if (list.size() % 2 == 1) return list.get(list.size() / 2 - 1);
        else {
            int x1 = list.get(list.size() / 2);
            int x2 = list.get(list.size() / 2 - 1);
            return (x1 + x2) * 1.0 / 2;
        }
    }
}
