package weekMatch.single;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/5 14:50
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        Q02 q = new Q02();
//        System.out.println(q.orchestraLayout(5, 2, 2));
        int mum = 7;
        for (int i = 0; i < mum; i++) {
            for (int j = 0; j < mum; j++) {
                System.out.print(q.orchestraLayout(mum, i, j) + " ");
            }
            System.out.println();
        }
    }

    public int orchestraLayout(int num, int xPos, int yPos) {
        long size = num - 1;

        long code = 1;

        int len = Math.min(Math.min(xPos, yPos), Math.min(num - yPos - 1, num - xPos - 1));
        size -= (len * 2);
        code += ((size + 2 + num - 1) * len * 2);
        code = code % 9;


//        while (!(xPos == level || yPos == level || xPos == num - level - 1 || yPos == num - level - 1)) {
//            code = (size * 4 + code) % 9;
//            size -= 2;
//            level++;
//        }
        if (xPos == (long) len && yPos == (long) len) return (int) code;
        if (xPos == (long) len) code = code + yPos - (long) len;
        else if (yPos == num - (long) len - 1) code = code + size + xPos - (long) len;
        else if (xPos == num - (long) len - 1) code = code + size * 2 + (num - (long) len - 1 - yPos);
        else if (yPos == (long) len) code = code + size * 3 + (num - (long) len - 1 - xPos);

        return code % 9 == 0 ? 9 : (int) (code % 9);
    }
    
}
