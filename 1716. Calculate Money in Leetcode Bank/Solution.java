class Solution {
    public int totalMoney(int n) {
        int totalMoney = 0;
        int fullWeeks = n / 7;
        int remainingDays = n % 7;
        
        for (int i = 0; i < fullWeeks; i++) {
            totalMoney += 7 * (i + 1) + 21; 
            // i + 1 is start of the week, 21 is the sum of 1 to 7  
        }

        for ( int i = 0; i < remainingDays; i++) {
            totalMoney += (fullWeeks + 1) + i; 
        }

        return totalMoney;
    }
}