import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak = -1;

        for (int num : nums) {
            int count = 0;
            long current = num;

            while (set.contains((int) current)) {
                count++;
                current *= current;

                if (current > Integer.MAX_VALUE) break;
            }

            maxStreak = Math.max(maxStreak, count);
        }

        return maxStreak < 2 ? -1 : maxStreak;
    }
}