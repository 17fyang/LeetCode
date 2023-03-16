package Q2000_2100;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2023/3/15 23:45
 */
public class Q2038 {
    public static void main(String[] args) {
        System.out.println(new Q2038().winnerOfGame("AAAABBBB"));
    }

    public boolean winnerOfGame(String colors) {
        char[] arr = (colors + "0").toCharArray();

        int aNum = 0;
        int bNum = 0;

        char now = '0';
        int num = 0;
        for (char c : arr) {
            if (now != c) {
                if (now == 'A' && num > 2) {
                    aNum += num - 2;
                } else if (now == 'B' && num > 2) {
                    bNum += num - 2;
                }
                num = 1;
                now = c;
                continue;
            }

            num++;
        }
        return aNum > bNum;
    }

}
