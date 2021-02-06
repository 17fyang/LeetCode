package Q400_500;

import java.util.*;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2020/12/25 14:00
 * @Description:
 */
public class Q433 {
    public static void main(String[] args) {
        String start = "AAAAAAAA";
        String end = "CCCCCCCC";
        String[] bank = new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"};
        new Q433().minMutation(start, end, bank);
    }

    public int minMutation(String start, String end, String[] bank) {
        MyNode[] nodes = new MyNode[bank.length];

        for (int i = 0; i < bank.length; i++) nodes[i] = new MyNode(bank[i], new LinkedList<>());

        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank.length; j++) {
                if (i == j) continue;
                if (distance(bank[i], bank[j]) == 1) {
                    nodes[i].list.add(nodes[j]);
                }
            }
        }

        MyNode startNode = new MyNode(start, new LinkedList<>());

        for (int i = 0; i < nodes.length; i++) {
            int dis = distance(startNode.str, nodes[i].str);
            if (dis == 0) {
                startNode = nodes[i];
                break;
            } else if (dis == 1) {
                startNode.list.add(nodes[i]);
            }
        }

        Set<MyNode> set = new HashSet<>();
        int total = 0;
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(startNode);
        set.add(startNode);
        while (!queue.isEmpty()) {
            total++;
            int len = queue.size();
            System.out.println(len);
            for (int i = 0; i < len; i++) {
                MyNode node = queue.poll();
                set.add(node);
                for (MyNode n : node.list) {
                    if (!set.contains(n)) queue.add(n);
                    int dis = distance(end, n.str);
                    if (dis == 0) return total;
                }
            }
        }
        return -1;
    }


    private int distance(String s1, String s2) {
        int total = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) total++;
            if (total >= 2) return total;
        }
        return total;
    }
}

class MyNode {
    String str;
    List<MyNode> list;

    public MyNode(String str, List<MyNode> list) {
        this.str = str;
        this.list = list;
    }
}