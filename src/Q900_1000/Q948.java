package Q900_1000;

import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/6/4 23:16
 * @Description:
 */
public class Q948 {
    public static void main(String[] args) {

    }

    public int bagOfTokensScore(int[] tokens, int P) {
        TreeSet<Node> set = new TreeSet<>((n1, n2) -> {
            if (n1.value != n2.value) return n1.value - n2.value;
            return n1.index - n2.index;
        });

        for (int i = 0; i < tokens.length; i++) {
            set.add(new Node(i, tokens[i]));
        }

        int left = P;
        int point = 0;
        int maxPoint = 0;
        while (true) {
            while (!set.isEmpty() && left >= set.first().value) {
                Node first = set.first();
                set.remove(first);
                left -= first.value;
                point++;
                if (point > maxPoint) maxPoint = point;
            }
            while (!set.isEmpty() && left < set.first().value && point > 0) {
                Node last = set.last();
                set.remove(last);
                left += last.value;
                point--;
            }
            if (set.isEmpty() || left < set.first().value) return maxPoint;
        }
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }


}
