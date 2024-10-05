
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }
        if (matches(s1Freq, windowFreq)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;
            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }
}