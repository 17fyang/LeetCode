package Q1300_1400;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/11 13:55
 * @Description:
 */
public class Q1306 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 2, 1, 2};
        System.out.println(new Q1306().canReach(arr, 2));
    }

    public boolean canReach(int[] arr, int start) {
        MyNode[] nodes = new MyNode[arr.length];
        for (int i = 0; i < arr.length; i++) nodes[i] = new MyNode(i);

        Queue<MyNode> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                queue.add(nodes[i]);
            } else {
                if (i - arr[i] >= 0) nodes[i - arr[i]].father.add(nodes[i]);
                if (i + arr[i] < arr.length) nodes[i + arr[i]].father.add(nodes[i]);
            }
        }

        boolean[] flag = new boolean[arr.length];
        while (!queue.isEmpty()) {
            MyNode m = queue.poll();
            if (m.index == start) return true;
            flag[m.index] = true;
            for (MyNode t : m.father) {
                if (!flag[t.index])
                    queue.add(t);
            }
        }
        return false;
    }


}

class MyNode {
    int index;
    List<MyNode> father = new LinkedList<>();

    public MyNode(int index) {
        this.index = index;
    }
}