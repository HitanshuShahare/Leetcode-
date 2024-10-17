class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        int ones = 0;

        for (char c: s.toCharArray()) {
            if (c == '1') {
                ++ones;
            } else {
                ans += ones;
            }
        }
        return ans;
    }
}