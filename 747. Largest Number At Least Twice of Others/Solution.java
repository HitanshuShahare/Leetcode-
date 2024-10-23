class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        
        int maxIndex = 0;
        int secondMax = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                secondMax = nums[maxIndex];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        if (nums[maxIndex] >= 2 * secondMax) {
            return maxIndex;
        }
        return -1;
    }
}