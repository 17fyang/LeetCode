package Q0_100;

import java.util.*;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/15 12:49
 * @Description:
 */
public class Q15 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Pack> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) set.add(new Pack(nums[i], nums[left], nums[right]));
                if (sum <= 0) left++;
                else right--;
            }
        }

        List<List<Integer>> list = new LinkedList<>();

        for (Pack p : set) {
            List<Integer> temp = new LinkedList<>();
            temp.add(p.first);
            temp.add(p.second);
            temp.add(p.third);
            list.add(temp);
        }

        return list;
    }

    static class Pack {
        int first;
        int second;
        int third;

        public Pack(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            Pack pack = (Pack) o;
            return first == pack.first &&
                    second == pack.second &&
                    third == pack.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }
}
