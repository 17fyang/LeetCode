package Q700_800;

import java.util.Arrays;

public class Q735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q735().asteroidCollision(new int[]{-2, 2, -1, -2})));
    }
    
    public int[] asteroidCollision(int[] asteroids) {
        int index = 0;
        while (index < asteroids.length && asteroids[index] < 0) index++;
        while (index < asteroids.length) {
            if (asteroids[index] < 0) {
                int i = index - 1;

                while (i >= 0 && asteroids[i] >= 0 && asteroids[i] <= asteroids[index] * -1) {
                    if (asteroids[i] == asteroids[index] * -1) asteroids[index] = 0;
                    asteroids[i--] = 0;
                }
                if (i >= 0 && asteroids[i] > 0) {
                    asteroids[index] = 0;
                }
            }

            index++;
        }

        return Arrays.stream(asteroids).filter(item -> item != 0).toArray();
    }
}
