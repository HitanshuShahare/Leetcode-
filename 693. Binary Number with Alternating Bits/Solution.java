class Solution {
    public boolean hasAlternatingBits(int n) {
        int xor = n ^ (n >> 1);
        return (xor & (xor + 1)) == 0; 
    }
}