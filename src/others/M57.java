package others;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: M57
 * Description:输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * date: 2020/5/30 15:33
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class M57 {
    public static void main(String[] args) {
        int arr[][] = new M57().findContinuousSequence(15);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] findContinuousSequence(int target) {
        int maxNum = (int) Math.sqrt(2 * target) + 2;
        List<int[]> list = new LinkedList<>();
        for (int i = 2; i < maxNum; i++) {
            int[] arr = checkSingle(target, i);
            if (arr != null) list.add(arr);
        }
        Collections.sort(list, new myComparator());
        return list.toArray(new int[list.size()][]);
    }

    private int[] checkSingle(int target, int i) {
        if (i % 2 == 1) {
            if (target % i == 0) {
                int mid = target / i;
                int start = mid - i / 2;
                if (start <= 0) return null;
                int arr[] = new int[i];
                for (int j = 0; j < i; j++) arr[j] = start + j;
                return arr;
            }
        } else {
            if (target % (i / 2) == 0) {
                target = target / (i / 2);
                if (target % 2 == 0) return null;
                int start = target / 2 - (i / 2 - 1);
                if (start <= 0) return null;
                int arr[] = new int[i];
                for (int j = 0; j < i; j++) arr[j] = start + j;
                return arr;
            }
        }
        return null;
    }

    class myComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
