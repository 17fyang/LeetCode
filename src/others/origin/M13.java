package others.origin;

/*
 * ������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��
 * һ�������˴����� [0, 0] �ĸ��ӿ�ʼ�ƶ���
 * ��ÿ�ο��������ҡ��ϡ����ƶ�һ�񣨲����ƶ��������⣩��
 * Ҳ���ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] ����Ϊ3+5+3+7=18��
 * �������ܽ��뷽�� [35, 38]����Ϊ3+5+3+8=19��
 * ���ʸû������ܹ�������ٸ����ӣ�
 */
public class M13 {
    private static int sum = 0;

    public static void main(String[] args) {
        int result = movingCount(38, 15, 9);
        System.out.println(result);
    }

    public static int movingCount(int m, int n, int k) {
        boolean flag[][] = new boolean[m][n];
        func(flag, 0, 0, k);
        return sum;
    }

    static void func(boolean[][] flag, int m, int n, int k) {
        if (!(m >= 0 && m < flag.length && n >= 0 && n < flag[0].length)) return;
        if (flag[m][n] == true) return;
        if (m / 100 + m % 100 / 10 + m % 10 + n / 100 + n % 100 / 10 + n % 10 > k) return;
        flag[m][n] = true;
        sum++;

        func(flag, m - 1, n, k);
        func(flag, m + 1, n, k);
        func(flag, m, n - 1, k);
        func(flag, m, n + 1, k);
    }
}
