class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1;
        while (n/factor > 0) {
            long lowerDigit = n - (n / factor) * factor;
            long currentDigit = (n / factor) % 10;
            long higherDigits = n / (factor * 10);

            if (currentDigit == 0) {
                count += higherDigits * factor;
            } else if (currentDigit == 1) {
                count += higherDigits * factor + lowerDigits + 1;
            } else {
                count += (higherDigits + 1) * factor;
            }

            factor *= 10;
        }
        return count;
    }
}