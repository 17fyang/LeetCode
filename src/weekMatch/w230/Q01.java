package weekMatch.w230;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/28 10:27
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        List<List<String>> list = new LinkedList<>();
        list.add(Arrays.asList("phone", "blue", "pixel"));
        list.add(Arrays.asList("computer", "silver", "phone"));
        list.add(Arrays.asList("phone", "gold", "iphone"));
        System.out.println(new Q01().countMatches(list, "type", "phone"));
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int num = 0;
        for (List<String> itemList : items) {
            if (ruleKey.equals("type") && itemList.get(0).equals(ruleValue)) num++;
            else if (ruleKey.equals("color") && itemList.get(1).equals(ruleValue)) num++;
            else if (ruleKey.equals("name") && itemList.get(2).equals(ruleValue)) num++;
        }
        return num;

    }
}
