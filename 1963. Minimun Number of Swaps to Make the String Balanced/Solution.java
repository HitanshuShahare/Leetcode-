class Solution {
    public int minSwaps(String s) {
       int imbalance = 0, swaps = 0;

       for (char c : s.toCharArray()) {
            if (c == '[') {
                imbalance--;
            }
            else {
                imbalance++;
            }
            if (imbalance > 0) {
                swaps++;
                imbalance -= 2;
            }
       } 
       return swaps;
    }
}