class Solution {
    public int minAddToMakeValid(String s) {
        int openBracketsNeeded = 0;
        int closeBracketsNeeded = 0;

        for (int ch : s.toCharArray()) {
            if (ch == '(') {
                openBracketsNeeded++;
            } else if (ch == ')') {
                if (openBracketsNeeded > 0) {
                    openBracketsNeeded--;
                } else {
                    closeBracketsNeeded++;
                }
            }
        }
        return openBracketsNeeded + closeBracketsNeeded;
    }
}