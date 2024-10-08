class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0; 
        StringBuilder merged = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();

        while (i < len1 &&  j < len2) {
            merged.append(word1.charAt(i++));
            merged.append(word2.charAt(j++));
        }

        while (i < len1) {
            merged.append(word1.charAt(i++));
        }

        while (j < len2) {
            merged.append(word2.charAt(j++));
        }
        return merged.toString();
    }
}