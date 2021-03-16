package weekMatch.d47;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/6 22:25
 * @Description:
 */
public class Q02 {
    Set<Integer> set;
    Set<Integer> useSet;

    public static void main(String[] args) {
        new Q02().checkPowersOfThree(5);
    }


    public boolean checkPowersOfThree(int n) {
        set = new HashSet<>();
        useSet = new HashSet<>();
        int[] mi = new int[17];
        for (int i = 0; i < mi.length; i++) {
            mi[i] = (int) Math.pow(3, i);
        }

        int maxIndex = 0;
        for (int i = 0; i < mi.length; i++) {
            if (n < mi[i]) break;
            maxIndex = i;
        }


        for (int i = 0; i < maxIndex; i++) {
            set.add(mi[i]);
        }

        return false;
    }

    private boolean track(int[] mi, int index, int endIndex, int n) {
        useSet.add(index);
        for (int i = 0; i < endIndex; i++) {
            if (set.contains(n - mi[i])) return true;

            if (!useSet.contains(i)) {
                set.add(mi[i]);

                track(mi, index, endIndex, n);


            }


        }
        useSet.remove(index);
        return false;
    }
}
