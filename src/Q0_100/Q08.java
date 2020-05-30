package Q0_100;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ������ʵ��һ�� atoi ������ʹ���ܽ��ַ���ת����������
 */
public class Q08 {
    public static void main(String[] args) {
        String str = "6216.51";
        int result = myAtoi(str);
        System.out.println(result);
    }

    public static int myAtoi(String str) {
        Pattern p = Pattern.compile(" *(-?|\\+?)[0-9]+.*");
        if (!p.matcher(str).matches()) return 0;
        Matcher m = Pattern.compile("(-?|\\+?)[0-9]+").matcher(str);
        if (m.find()) {
            try {
                return Integer.parseInt(m.group());
            } catch (Exception e) {
                if (m.group().startsWith("-")) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        }
        return 0;
    }
}
