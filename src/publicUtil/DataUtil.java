package publicUtil;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/12 14:22
 * @Description:
 */
public class DataUtil {

    public static int[][] parseDoubleIntArray(String s) {
        s = preDealArray(s);
        String[] strArr = s.split("],\\[");
        strArr[0] = strArr[0].substring(1);
        String lastStr = strArr[strArr.length - 1];
        strArr[strArr.length - 1] = lastStr.substring(0, lastStr.length() - 1);
        int[][] arr = new int[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = parseIntArray("[" + strArr[i] + "]");
        }
        return arr;
    }

    public static int[] parseIntArray(String s) {
        s = preDealArray(s);
        String[] strArr = s.split(",");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

    private static String preDealArray(String s) {
        s = s.replaceAll("\\s", "");
        return s.substring(1, s.length() - 1);
    }

}
