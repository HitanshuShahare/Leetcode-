class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
       String[] words1 = sentence1.split(" ");
       String[] words2 = sentence2.split(" ");

       int i = 0, j = 0;
       int len1 = words1.length, len2 = words2.length;

       while (i < len1 && i < len2 && words1[i].equals(words2[i])) {
            i++;
       } 

       while (j < len1 - i && j < len2 - i && words1[len1 - 1 - j].equals(words2[len2 - 1 - j])) {
            j++;
       }

       return i + j == Math.min(len1, len2);
    }
}