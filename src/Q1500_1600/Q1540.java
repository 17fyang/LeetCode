package Q1500_1600;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/20 23:11
 */
public class Q1540 {
    public static void main(String[] args) {
        new Q1540().canConvertString("jicfxaa", "ocxltbp", 27);
    }

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] from = s.toCharArray();
        char[] to = t.toCharArray();

        int[] flag = new int[26];
        int len = from.length;
        for (int i = 0; i < len; i++) {
            int interval = to[i] >= from[i] ? to[i] - from[i] : to[i] - from[i] + 26;
            flag[interval]++;
        }

        int max = 0;
        int maxK = 0;
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] >= max) {
                max = flag[i];
                maxK = 26 * flag[i] - 26 + i;
            }
        }
        return maxK <= k;
    }
}
