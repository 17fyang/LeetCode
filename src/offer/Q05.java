package offer;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Q05 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sb));
    }

    public static String replaceSpace(StringBuffer str) {
        char[] c = str.toString().toCharArray();
        int spaceNum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') spaceNum++;
        }

        char newChar[] = new char[c.length + spaceNum * 2];
        int pointer = newChar.length - 1;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                newChar[pointer--] = '0';
                newChar[pointer--] = '2';
                newChar[pointer--] = '%';
            } else
                newChar[pointer--] = c[i];
        }
        return new String(newChar);
    }
}
