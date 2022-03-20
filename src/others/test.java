package others;

public class test {
    public static final int TIMES = 10000000;

    public static void main(String[] args) {

        double sum = 0;
        int i = 0;
        while (i < TIMES) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;

            if (x * x + y * y > 1) continue;

            i++;
            double r = Math.sqrt(x * x + y * y);
            sum += r;
        }
        System.out.println(sum / TIMES);
    }

}

