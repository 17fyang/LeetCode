package weekMatch.team;

import java.util.PriorityQueue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/10 14:53
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<MyNode> queue = new PriorityQueue<>((n1, n2) -> {
            if (n1.waterTime != n2.waterTime) return n2.waterTime - n1.waterTime;
            else if (n1.nextWaterTime != n2.nextWaterTime) return n2.nextWaterTime - n1.nextWaterTime;
            return n1.index - n2.index;
        });

        return 0;

    }
}

class MyNode {
    int bucket;
    int vat;
    int waterTime;
    int nextWaterTime;
    int index;

    public MyNode(int bucket, int vat, int index) {
        this.bucket = bucket;
        this.vat = vat;
        this.index = index;

        reWater();
    }

    public void reWater() {
        this.waterTime = water(bucket, vat);
        this.nextWaterTime = water(bucket + 1, vat);
    }

    private int water(int b, int v) {
        return v % b == 0 ? v / b : (v / b + 1);
    }
}
