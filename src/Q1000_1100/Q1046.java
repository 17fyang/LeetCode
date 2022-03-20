package Q1000_1100;

import java.util.PriorityQueue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/31 11:48
 * @Description:
 */
public class Q1046 {
    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for (int i : stones) queue.add(i);

        while (queue.size() > 1) {
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            if (stone1 != stone2) {
                queue.add(Math.abs(stone1 - stone2));
            }
        }
        if (queue.isEmpty()) return 0;
        else return queue.poll();
    }
}
