package others.origin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: ��ѻ���ɻ���
 * @date: 2021/1/12 19:04
 * @Description:
 */
public class M1711 {
    private Map<String, List<Integer>> map;
    private String[] text;

    public static void main(String[] args) {

        String[] words = new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        System.out.println(new M1711().findClosest(words, "a", "student"));
    }

    public int findClosest(String[] words, String word1, String word2) {
        if (map == null || text.length != words.length) {
            text = words;
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                List<Integer> list = map.getOrDefault(words[i], new LinkedList<>());
                list.add(i);
                map.put(words[i], list);
            }
        }

        return getMinDistance(map.get(word1), map.get(word2));
    }

    private int getMinDistance(List<Integer> list1, List<Integer> list2) {
        return 0;
    }
}
