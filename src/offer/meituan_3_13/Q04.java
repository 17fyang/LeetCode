package offer.meituan_3_13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/13 15:52
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextInt();
        MyNode[] nodes = new MyNode[n];
        for (int i = 0; i < n; i++) nodes[i] = new MyNode(sc.nextInt(), i);

        for (int i = 0; i < n - 1; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            nodes[left - 1].list.add(nodes[right - 1]);
            nodes[right - 1].list.add(nodes[left - 1]);
        }

        int[] choice = new int[n];
        int[] unChoice = new int[n];

        Queue<MyNode> queue = new LinkedList<>();
        boolean[] flag = new boolean[n];
        choice[0] = nodes[0].val;
        queue.addAll(nodes[0].list);
        flag[0] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                MyNode temp = queue.poll();
                flag[temp.index] = true;

                MyNode lastNode = null;
                for (MyNode nn : temp.list)
                    if (flag[nn.index]) {
                        lastNode = nn;
                    } else {
                        queue.add(nn);
                    }

                unChoice[temp.index] = Math.max(choice[lastNode.index], unChoice[lastNode.index]);
                choice[temp.index] = unChoice[lastNode.index] + temp.val;

            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.max(choice[i], unChoice[i]));
        }
        System.out.println(max);
    }
}

class MyNode {
    int val;
    int index;
    LinkedList<MyNode> list = new LinkedList<>();

    public MyNode(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
