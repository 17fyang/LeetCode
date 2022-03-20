package weekMatch.week.w230;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/28 10:27
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {
        int[][] arr = new int[10][];
        arr[0] = new int[]{1, 5};
        arr[1] = new int[]{6, 5};
        arr[2] = new int[]{7, 5};
        arr[3] = new int[]{14, 5};
        arr[4] = new int[]{15, 3};
        arr[5] = new int[]{16, 4};
        arr[6] = new int[]{17, 5};
        arr[7] = new int[]{18, 1};
        arr[8] = new int[]{19, 2};
        arr[9] = new int[]{20, 2};
        System.out.println(Arrays.toString(new Q04().getCollisionTimes(arr)));
    }

    public double[] getCollisionTimes(int[][] cars) {
        double[] result = new double[cars.length];


        Car head = null;
        Car last = null;
        for (int i = 0; i < cars.length; i++) {
            Car temp = new Car(i, cars[i][0], cars[i][1]);
            temp.prev = last;
            if (head == null) {
                head = temp;
            } else {
                last.next = temp;
            }
            last = temp;
        }

        TreeMap<Car, Object> map = new TreeMap<>((c1, c2) -> {
            double value = (c1.catchTime - c2.catchTime);
            if (value == 0) return c1.index - c2.index;
            else return value > 0 ? 1 : -1;
        });

        Car temp = head;
        while (temp != null) {
            if (temp.next == null || temp.speed <= temp.next.speed) temp.catchTime = Double.MAX_VALUE;
            else {
                temp.catchTime = (temp.next.startLocation - temp.startLocation) * 1.0 / (temp.speed - temp.next.speed);
            }
            temp = temp.next;
        }

        Object o = new Object();
        temp = head;
        while (temp != null) {
            map.put(temp, o);
            temp = temp.next;
        }

        while (!map.isEmpty()) {
            Map.Entry<Car, Object> firstEntry = map.firstEntry();

            result[firstEntry.getKey().index] = firstEntry.getKey().catchTime == Double.MAX_VALUE ? -1 : firstEntry.getKey().catchTime;
            Iterator<Map.Entry<Car, Object>> it = map.entrySet().iterator();
            if (it.hasNext()) {
                it.next();
                it.remove();
            }

            Car prev = firstEntry.getKey().prev;
            Car next = firstEntry.getKey().next;
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;

            if (prev != null) {
                map.remove(prev);
                if (next == null || prev.speed <= next.speed)
                    prev.catchTime = Double.MAX_VALUE;
                else
                    prev.catchTime = (next.startLocation - prev.startLocation) * 1.0 / (prev.speed - next.speed);
                map.put(prev, o);
            }

        }
        return result;

    }


}

class Car {
    int index;
    int startLocation;
    int speed;
    double catchTime;
    Car next;
    Car prev;

    public Car(int index, int startLocation, int speed) {
        this.index = index;
        this.startLocation = startLocation;
        this.speed = speed;
    }
}
