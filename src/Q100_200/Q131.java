package Q100_200;

import java.util.*;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/7 12:06
 * @Description:
 */
public class Q131 {
    List<List<String>> resultList;
    
    public List<List<String>> partition(String s) {
        resultList = new LinkedList<>();
        Map<Integer, List<Integer>> map = getIndex(s);

        track(map, new LinkedList<>(), s, 0);
        return resultList;
    }

    private void track(Map<Integer, List<Integer>> map, List<String> list, String str, int startIndex) {
        List<Integer> nextIndex = map.get(startIndex);
        if (nextIndex == null) {
            resultList.add(list);
            return;
        }

        for (int index : nextIndex) {
            List<String> nextList = new LinkedList<>(list);
            nextList.add(str.substring(startIndex, index + 1));
            track(map, nextList, str, index + 1);
        }
    }

    private Map<Integer, List<Integer>> getIndex(String s) {
        int n = s.length();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                List<Integer> list = map.getOrDefault(l, new LinkedList<>());
                list.add(r);
                map.put(l, list);
                l--;
                r++;
            }
        }
        return map;
    }

}

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
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
