package others.origin;

/*
数字以0123456789101112131415…的格式序列化到一个字符序列中。
在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

 */
public class m44 {
    public static void main(String[] args) {
        m44 m = new m44();
//        for (int i = 0; i < 1000; i++) {
//            System.out.print(m.findNthDigit(i));
//        }
        System.out.print(m.findNthDigit(1000000000));
    }

    public int findNthDigit(long n) {
        if (n < 10) return (int) n;
        long value = 90;
        int length = 2;
        long total = 10;
        long lastTotal = 10;
        while (n >= (total += value * length)) {
            lastTotal = total;
            value = value * 10;
            length++;
        }
        n = n - lastTotal;
        int intN = (int) n;
        int number = intN / length + (int) (Math.pow(10, length - 1));
        return getLocation(intN % length, number);
    }

    private int getLocation(int i, int number) {
        return String.valueOf(number).charAt(i) - 48;
    }
}
