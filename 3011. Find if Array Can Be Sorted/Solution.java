class Solution {
    public boolean canSortArray(int[] nums) {
        int prevSetBits = 0;
        int prevMax = Integer.MIN_VALUE;
        int currMax = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;

        for (final int num : nums) {
            final int setBits = Integer.bitCount(num);
            if (setBits != prevSetBits) {
                if (prevMax > currMin) return false;
                prevSetBits = setBits;
                prevMax = currMax;
                currMax = num;
                currMin = num;
            } else {
                currMax = Math.max(currMax, num);
                currMin = Math.min(currMin, num);
            }
        }
        return prevMax <= currMin;
    }
}