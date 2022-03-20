package weekMatch.week.w232;

import publicUtil.DataUtil;

import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/14 10:39
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[][] arr = DataUtil.parseDoubleIntArray("[[1,2],[3,5],[2,2]]");
        System.out.println(new Q03().maxAverageRatio(arr, 2));

    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        TreeSet<MyClass> set = new TreeSet<>((c1, c2) -> {
            if (c1.interest == c2.interest) return c1.index - c2.index;
            return c2.interest - c1.interest > 0 ? 1 : -1;
        });

        for (int i = 0; i < classes.length; i++) {
            set.add(new MyClass(i, classes[i][1], classes[i][0]));
        }

        for (int i = 0; i < extraStudents; i++) {
            MyClass first = set.first();

            if (first.interest == -1) return 1;
            set.remove(first);
            first.pass++;
            first.total++;
            first.resetInterest();
            set.add(first);
        }

        int n = set.size();
        double total = 0;
        for (MyClass m : set) {
            total += m.pass * 1.0 / m.total;
        }
        return total / n;


    }
}

class MyClass {
    int total;
    int index;
    int pass;
    double interest;

    public MyClass(int index, int total, int pass) {
        this.total = total;
        this.index = index;
        this.pass = pass;

        resetInterest();
    }

    public void resetInterest() {
        if (pass == total) interest = -1;
        else interest = (pass + 1) * 1.0 / (total + 1) - (pass * 1.0 / total);
    }
}
