package weekMatch.week.w243;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/30 10:07
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
//        "28824579515"
//        8

        System.out.println(new Q02().maxValue("-132", 3));
    }

    public String maxValue(String n, int x) {
        char[] arr = n.toCharArray();
        if (arr[0] == '-') {
            for (int i = 1; i < arr.length; i++) {
                if (x < arr[i] - '0') {
                    return "-" + n.substring(1, i) + x + n.substring(i);
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (x > arr[i] - '0') {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        }
        return n + x;
    }

}
