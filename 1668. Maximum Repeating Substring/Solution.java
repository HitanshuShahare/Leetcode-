class Solution {
    public int maxRepeating(String sequence, String word) {
      int maxK = 0;
      String repeatedWord = word;
      while (sequence.contains(repeatedWord)) {
        maxK++;
        repeatedWord += word;
      }
      return maxK;  
    }
}