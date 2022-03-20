package weekMatch.double_week.d46;

import java.util.*;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/20 23:40
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 10, 2, 3, 6, 15};
        int[][] edgs = new int[6][];
        edgs[0] = new int[]{0, 1};
        edgs[1] = new int[]{0, 2};
        edgs[2] = new int[]{1, 3};
        edgs[3] = new int[]{1, 4};
        edgs[4] = new int[]{2, 5};
        edgs[5] = new int[]{2, 6};


        System.out.println(Arrays.toString(new Q04().getCoprimes(nums, edgs)));
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        Map<Integer, LinkedList<Integer>> relationMap = new HashMap<>();

        for (int[] arr : edges) {
            LinkedList<Integer> list = relationMap.getOrDefault(arr[0], new LinkedList<>());
            list.add(arr[1]);
            relationMap.put(arr[0], list);

            list = relationMap.getOrDefault(arr[1], new LinkedList<>());
            list.add(arr[0]);
            relationMap.put(arr[1], list);
        }


        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
            nodes[i].num = nums[i];
        }

        boolean[] flag = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {

            int last = queue.poll();
            flag[last] = true;
            TreeNode lastNode = nodes[last];

            List<Integer> list = relationMap.get(last);
            if (list == null) continue;

            for (int val : list) {
                if (!flag[val]) {
                    lastNode.son.add(nodes[val]);
                    nodes[val].father = lastNode;
                    queue.add(val);
                }
            }
        }

        int[] result = new int[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            TreeNode node = nodes[i];
            TreeNode temp = nodes[i];
            while (temp.father != null) {
                if (isZhi(node.num, temp.father.num)) {
                    result[i] = temp.father.val;
                    break;
                } else {
                    temp = temp.father;
                }
            }
            if (temp.father == null) result[i] = -1;
        }
        return result;

    }


    private boolean isZhi(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return b == 1;
    }
}

class TreeNode {
    TreeNode father;
    int val;
    int num;
    List<TreeNode> son = new LinkedList<>();

    public TreeNode(int val) {
        this.val = val;
    }
}
