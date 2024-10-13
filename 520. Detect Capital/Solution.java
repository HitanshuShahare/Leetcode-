class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) return true;
        boolean isFirstCapital = Character.isUpperCase(word.charAt(0));
        boolean isSecondCapital = Character.isUpperCase(word.charAt(1));

        if (!isFirstCapital && isSecondCapital) return false;

        for (int i = 2; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i)) != isSecondCapital) {
                return false;
            }
        }
        return true;
    }
}