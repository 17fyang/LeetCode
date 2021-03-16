package offer.meituan_3_13;

import java.util.Scanner;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/13 17:37
 * @Description:
 */
public class Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        MyNode[] nodes = new MyNode[n];
        for (int i = 0; i < n; i++) nodes[i] = new MyNode(sc.nextInt(), i);

        boolean[] flag = new boolean[n];
        for (int i = 0; i < m; i++) {
            MyNode left = nodes[sc.nextInt() - 1];
            MyNode right = nodes[sc.nextInt() - 1];
            if (left == right) continue;
            if (left.val == right.val) continue;
            MyNode max = left.val > right.val ? left : right;
            MyNode min = left.val > right.val ? right : left;

            max.list.add(min);
            flag[min.index] = true;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!flag[i]) max = Math.max(max, maxHeight(nodes[i]));
        }
        System.out.println(max);
    }

    private static int maxHeight(MyNode root) {
        int max = 0;
        for (MyNode n : root.list) {
            max = Math.max(max, maxHeight(n));
        }
        return max + 1;
    }
}
