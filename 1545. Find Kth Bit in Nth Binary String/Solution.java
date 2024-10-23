class Solution {
    public char findKthBit(int n, int k) {
        return findKthBitRecursive(n, k);
    }

    private char findKthBitRecursive(int n, int k) {
        if (n == 1) return '0';

        int length = (1 << n) - 1;

        int mid = length / 2 + 1;

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBitRecursive(n - 1, k);
        } else {
            int mirroredK = length - k + 1;
            return invert(findKthBitRecursive(n - 1, mirroredK));
        }
    }
    
    private char invert(char bit) {
        return bit == '0' ? '1' : '0';
    }

}