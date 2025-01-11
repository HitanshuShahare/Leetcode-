class Solution {
    public boolean canConstruct(String s, int k) {
      if (s.length() < k)
        return false;
  
      int[] count = new int[26];
  
      for (final char c : s.toCharArray())
        count[c - 'a'] ^= 1;
  
      return Arrays.stream(count).filter(c -> c % 2 == 1).count() <= k;
    }
  }