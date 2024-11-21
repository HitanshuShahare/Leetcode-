public class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];
        for (char c : s.toCharArray()) count[c - 'a']++;
        if (count[0] < k || count[1] < k || count[2] < k) return -1;
        count[0] -= k; count[1] -= k; count[2] -= k;

        int[] windowCount = new int[3];
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            windowCount[s.charAt(right) - 'a']++;
            while (windowCount[0] > count[0] || windowCount[1] > count[1] || windowCount[2] > count[2]) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return n - maxLength;
    }
}
