package weekMatch.w226;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/31 11:37
 * @Description:
 */
public class Q04 {
    Map<Pair, Boolean> map;

    public static void main(String[] args) {
        String s = "abfsdfsfdsvsvsdffc";
        System.out.println(new Q04().checkPartitioning(s));
    }

    public boolean checkPartitioning(String s) {
        map = new HashMap<>();
        char[] arr = s.toCharArray();
        if (arr.length < 3) return false;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isHui(arr, 0, i) && isHui(arr, i, j) && isHui(arr, j, arr.length)) return true;
            }
        }
        return false;
    }

    private boolean isHui(char[] arr, int start, int end) {
        Pair pair = new Pair(start, end);
        Boolean cache = map.get(pair);
        if (cache != null) return cache;
        while (start < end && arr[start] == arr[end - 1]) {
            start++;
            end--;
        }
        map.put(pair, start >= end);
        return start >= end;
    }
}

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
        Arrays.sort(new int[]{2, 3, 5});

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return start == pair.start &&
                end == pair.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
