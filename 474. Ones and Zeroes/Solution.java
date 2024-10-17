class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] count = countZerosOnes(str);
            int zeros = count[0];
            int ones = count[1];

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] countZerosOnes(String str) {
        int zeros = 0;
        int ones = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        return new int[]{zeros, ones};
    }
}