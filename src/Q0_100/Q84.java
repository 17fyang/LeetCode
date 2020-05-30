package Q0_100;

/**
 * ClassName: Q84
 * Description:求最大矩形，单调栈入门
 * date: 2020/5/30 10:06
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class Q84 {
    public static void main(String[] args) {
        int arr[] = {3, 5, 5, 2, 5, 5, 6, 6, 4, 4, 1, 1, 2, 5, 5, 6, 6, 4, 1, 3};
        System.out.println(new Q84().largestRectangleArea(arr));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        //插入排序，但是其实不用插入排序，时间复杂度都一样
        Node arrNode[] = new Node[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int t = i;
            Node node = this.new Node(i, heights[i]);
            while (t > 0 && node.value > arrNode[t - 1].value) {
                arrNode[t] = arrNode[t - 1];
                t--;
            }
            arrNode[t] = node;
        }
        for (int n = 0; n < arrNode.length; n++) {
            int key = arrNode[n].value;
            int value = arrNode[n].key;
            int temp = key;
            for (int i = value - 1; i >= 0; i--) {
                if (heights[i] >= key) temp += key;
                else break;
            }
            for (int i = value + 1; i < heights.length; i++) {
                if (heights[i] >= key) temp += key;
                else break;
            }
            if (temp > max) max = temp;
        }

        return max;
    }

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

