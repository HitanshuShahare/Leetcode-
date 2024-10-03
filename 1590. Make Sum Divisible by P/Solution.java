import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        for ( int num : nums) {
            totalSum += num;
        }

        int remainder = (int)(totalSum % p);
        if (remainder == 0) {
            return 0;
        }

        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);

        int currentSum = 0;
        int minLen = n;

        for (int i = 0; i < n; i++) {
            currentSum = (currentSum + nums[i]) % p;

            int target = (currentSum - remainder + p) % p;

            if (prefixMap.containsKey(target)) {
                minLen = Math.min(minLen, i - prefixMap.get(target));
            }

            prefixMap.put(currentSum, i);
        }
        return minLen == n ? -1 : minLen;
    }
}