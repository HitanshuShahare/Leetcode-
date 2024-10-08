import java.lang.Math;
class Solution {
    public int maxPower(String s) {
        int max = 1;
        int count = 1;
        for(int i = 0; i < s.length() -1; i++) {
            if ( s.charAt(i) == s.charAt(i+1)) {
                count = count + 1;
                max = Math.max(max,count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}