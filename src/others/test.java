package others;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {
    public static final double P = 0.3;
    public static String result;

    public static void main(String[] args) {
        MyNode n1 = new MyNode(1);
        MyNode n2 = new MyNode(2);
        MyNode n3 = new MyNode(3);
        MyNode n4 = new MyNode(4);
        MyNode n5 = new MyNode(5);
        MyNode n6 = new MyNode(6);
        MyNode n66 = new MyNode(6);
        MyNode n7 = new MyNode(7);


        n1.next = n3;
        n3.next = n6;
        n6.next = n7;

        n2.next = n4;
        n4.next = n5;
        n5.next = n66;

        MyNode head = myMerge(n1, n2);

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }

    }

    public static MyNode myMerge(MyNode left, MyNode right) {
        if (left == null) return right;
        if (right == null) return left;
        MyNode head = null;
        MyNode temp = null;

        while (left != null && right != null) {
            MyNode min = left.value > right.value ? right : left;

            if (left.value > right.value) right = right.next;
            else left = left.next;

            if (head == null) {
                head = min;
                temp = head;
            } else {
                temp.next = min;
                temp = temp.next;
            }
        }

        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return head;
    }


    public static void mySqrt(String now, int target) {
        if (now.length() >= 6) {
            result = now;
            return;
        }

        int left = Integer.parseInt(now) * 10;
        int right = Integer.parseInt(now) * 10 + 10;

        for (int i = left; i <= right; i++) {
            if (i * i < target && (i + 1) * (i + 1) > target) {
                mySqrt(String.valueOf(i), target * 100);
                return;
            }
        }
    }


    public static String solution(String s, int n) {
        char[] arr = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        int left = 0;
        int right = n;
        int maxLen = 0;
        int maxStart = 0;

        while (right < arr.length) {
            if (map.size() >= n && !map.containsKey(arr[right])) {
                while (left < right && map.size() >= n) {
                    int num = map.get(arr[left]);

                    if (num == 1) map.remove(arr[left]);
                    else map.put(arr[left], num - 1);

                    left++;
                }
            } else {
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                right++;
            }

            if (right - left >= maxLen) {
                maxLen = right - left;
                maxStart = left;
            }
        }


//        int maxLen = 0;
//        int maxStart = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = n; j <= arr.length; j++) {
//                if (validate(arr, i, j, n) && (j - i) > maxLen) {
//                    maxLen = j - i;
//                    maxStart = i;
//                }
//            }
//        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public static boolean validate(char[] arr, int start, int end, int n) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            set.add(arr[i]);
        }
        return set.size() == n;
    }

    public static int myFunc() {
        int a = func1();
        int b = func2();

        if ((a == 1 && b == 0) || (a != 1 && b != 0)) return 0;
        else return 1;
    }

    public static int func1() {
        if (Math.random() <= P) return 1;
        else return -1;
    }

    public static int func2() {
        if (Math.random() <= 1 - P) return 0;
        else return -1;
    }

}

class MyNode {
    int value;
    MyNode next;

    public MyNode(int value) {
        this.value = value;

    }
}

