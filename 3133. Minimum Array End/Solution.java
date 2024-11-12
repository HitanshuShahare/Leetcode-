class Solution {
    public long minEnd(int n, int x) {
      final int kMaxBit = bitLength(n) + bitLength(x);
      final long k = n - 1;
      long ans = x;
      int kBinaryIndex = 0;
  
      for (int i = 0; i < kMaxBit; ++i) {
        if ((ans >> i & 1) == 0) {
          if ((k >> kBinaryIndex & 1) == 1)
            ans |= 1L << i;
          ++kBinaryIndex;
        }
      }
  
      return ans;
    }
  
    private int bitLength(int n) {
      return 32 - Integer.numberOfLeadingZeros(n);
    }
  }