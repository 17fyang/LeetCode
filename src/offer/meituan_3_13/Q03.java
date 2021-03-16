package offer.meituan_3_13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/13 15:52
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, MyNum> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arr[i] = val;
            if (!map.containsKey(val)) map.put(val, new MyNum(val));
        }

        TreeSet<MyNum> set = new TreeSet<>((n1, n2) -> {
            if (n1.times != n2.times) return n2.times - n1.times;
            else return n1.val - n2.val;
        });


        for (int i = 0; i < k; i++) {
            MyNum myNum = map.get(arr[i]);
            myNum.times += 1;
        }

        for (int i = 0; i < k; i++) {
            set.add(map.get(arr[i]));
        }

        for (int i = 0; i <= n - k; i++) {
            MyNum first = set.first();
            System.out.println(first.val);

            if (i == n - k) break;

            MyNum cur = map.get(arr[i]);
            set.remove(cur);
            cur.times--;
            set.add(cur);

            MyNum kDis = map.get(arr[i + k]);
            set.remove(kDis);
            kDis.times++;
            set.add(kDis);
        }
    }
}

class MyNum {
    int val;
    int times = 0;

    public MyNum(int val) {
        this.val = val;

    }

}