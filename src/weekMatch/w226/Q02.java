package weekMatch.w226;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/31 10:29
 * @Description:
 */
public class Q02 {


    public static void main(String[] args) {

    }

    public int[] restoreArray(int[][] adjacentPairs) {

        Set<Integer> startSet = new HashSet<>();
        Map<Integer, MyNode> map = new HashMap<>();
        for (int[] arr : adjacentPairs) {
            if (startSet.contains(arr[0])) startSet.remove(arr[0]);
            else startSet.add(arr[0]);
            if (startSet.contains(arr[1])) startSet.remove(arr[1]);
            else startSet.add(arr[1]);

            MyNode left = map.get(arr[0]);
            if (left == null) {
                left = new MyNode(arr[0]);
                map.put(arr[0], left);
            }

            MyNode right = map.get(arr[1]);
            if (right == null) {
                right = new MyNode(arr[1]);
                map.put(arr[1], right);
            }

            if (left.link1 == null) left.link1 = right;
            else left.link2 = right;

            if (right.link1 == null) right.link1 = left;
            else right.link2 = left;
        }

        int[] result = new int[adjacentPairs.length + 1];
        int location = 0;
        MyNode start = map.get(startSet.iterator().next());
        Set<MyNode> nodeSet = new HashSet<>();
        MyNode temp = start;
        while (temp.link2 != null || location == 0) {
            nodeSet.add(temp);
            result[location++] = temp.val;
            if (!nodeSet.contains(temp.link1)) temp = temp.link1;
            else temp = temp.link2;
        }
        result[location] = temp.val;
        return result;
    }

}

class MyNode {
    int val;
    MyNode link1;
    MyNode link2;

    public MyNode(int val) {
        this.val = val;
    }
}
