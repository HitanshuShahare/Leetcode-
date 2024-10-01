import java.util.HashMap;
import  java.util.Map;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // handles negative numbers properly
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        for (int remainder : remainderCount.keySet()) {
            int count = remainderCount.get(remainder);;

            // for Special case: if remainder is 0; it should be even
            if (remainder == 0) {
                if (count % 2 != 0) return false;
            } 
            // General case : remainder and k - remainder should have equal frequencies 
            else {
                int complement = k - remainder;
                if (remainderCount.getOrDefault(complement, 0) != count) {
                    return false;
                }
            }
        }
        return true;
    }
}
