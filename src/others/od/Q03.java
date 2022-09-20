package others.od;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/15 22:02
 */
public class Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int speed = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt() + sc.nextInt());
        }

        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list) {
            arr[i++] = num;
        }

        System.out.println(solution(arr, speed));


        Arrays.sort(arr);
        System.out.println(solution(arr, 3));
    }

    private static int solution(int[] arr, int speed) {
        int len = arr.length;

        DPStatus lastPick = new DPStatus(1, speed);
        DPStatus lastNotPick = new DPStatus(0, 0);
        DPStatus nowPick = new DPStatus(0, 0);
        DPStatus nowNotPick = new DPStatus(0, 0);
        for (int i = 1; i < len; i++) {
            int pass = arr[i] - arr[i - 1];
            if (pass >= speed) {
                nowPick.set(Math.max(lastPick.max, lastNotPick.max) + 1, speed);
                nowNotPick.set(Math.max(lastPick.max, lastNotPick.max), 0);
            } else if (pass >= lastNotPick.cdTime) {
                nowPick.set(lastNotPick.max + 1, speed);
                if (lastPick.max > lastNotPick.max) {
                    nowNotPick.set(lastPick.max, speed - pass);
                } else {
                    nowNotPick.set(lastNotPick.max, 0);
                }
            } else {
                nowPick.set(lastPick.max, speed);
                nowNotPick.set(lastNotPick.max, lastNotPick.cdTime - pass);
            }

            lastPick.set(nowPick.max, nowPick.cdTime);
            lastNotPick.set(nowNotPick.max, nowNotPick.cdTime);
        }
        return Math.max(nowPick.max, nowNotPick.max);
    }

    private static class DPStatus {
        private int max = 0;
        private int cdTime = 0;

        public DPStatus(int max, int cdTime) {
            this.max = max;
            this.cdTime = cdTime;
        }

        public void set(int max, int cdTime) {
            this.max = max;
            this.cdTime = cdTime;
        }
    }
}
