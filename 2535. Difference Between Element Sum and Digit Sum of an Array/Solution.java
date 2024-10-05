import java.lang.Math;

class Solution {
    public int differenceOfSum(int[] nums) {
        int eSum = 0;
        int dSum = 0;
        for(int num : nums) {
            eSum += num;
            while(num > 0){
                dSum += num % 10;
                num /= 10;
            }
        }
        return Math.abs(eSum - dSum);
    }
}