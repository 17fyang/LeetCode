package Q1600_1700;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Q1647 {
    public static void main(String[] args) {
        String in = "bbcebab";
        System.out.println(new Q1647().minDeletions(in));
    }

    public int minDeletions(String s) {
        if (s.isEmpty()) return 0;
        char[] arr = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        TreeSet<Node> set = new TreeSet<>((n1, n2) -> n1.time == n2.time ? n1.c - n2.c : n2.time - n1.time);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            set.add(new Node(entry.getKey(), entry.getValue()));
        }

        int count = 0;
        while (true) {
            Node first = set.pollFirst();
            if (set.isEmpty()) {
                return count;
            }
            Node n = set.first();
            if (first.time == n.time) {
                first.time--;
                count++;
                if(first.time!=0){
                    set.add(first);
                }
            }
        }
    }

    private static class Node {
        char c;
        int time;

        public Node(char c, int time) {
            this.c = c;
            this.time = time;
        }
    }

}
