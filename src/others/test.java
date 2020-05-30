package others;

public class test {
    public static void main(String[] args) {
        int weight[][] = new int[3][4];
        int value[][] = new int[3][4];

        weight[0][0] = 10;
        weight[0][1] = 20;
        weight[0][2] = 40;
        weight[0][3] = 30;
        weight[1][0] = 8;
        weight[1][1] = 21;
        weight[1][2] = 42;
        weight[1][3] = 60;
        weight[2][0] = 12;
        weight[2][1] = 30;
        weight[2][2] = 30;
        weight[2][3] = 45;
        value[0][0] = 5;
        value[0][1] = 8;
        value[0][2] = 5;
        value[0][3] = 20;
        value[1][0] = 6;
        value[1][1] = 10;
        value[1][2] = 4;
        value[1][3] = 10;
        value[2][0] = 4;
        value[2][1] = 5;
        value[2][2] = 10;
        value[2][3] = 15;
        int min = 9000;
        for (int i = 0; i < 3; i++) {
            int weight0 = weight[i][0];
            int value0 = value[i][0];
            for (int j = 0; j < 3; j++) {
                int weight1 = weight[j][1];
                int value1 = value[j][1];
                for (int k = 0; k < 3; k++) {
                    int weight2 = weight[k][2];
                    int value2 = value[k][2];
                    for (int l = 0; l < 3; l++) {
                        int totalWeight = weight0 + weight1 + weight2 + weight[l][3];
//                        System.out.println(totalWeight);
                        int totalvalue = value0 + value1 + value2 + value[l][3];
                        if (totalWeight <= 120 && totalvalue < min) {
                            min = totalvalue;
                            System.out.println(i + " " + j + " " + k + " " + l);
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }

}
