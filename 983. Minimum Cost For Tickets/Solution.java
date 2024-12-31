class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n - 1] + 1];
        boolean[] travelDay = new boolean[dp.length];

        for (int day : days) {
            travelDay[day] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            if (!travelDay[i]) {
                dp[i] = dp[i - 1];
            } else {
                int oneDayPass = dp[i - 1] + costs[0];
                int sevenDayPass = dp[Math.max(0, i - 7)] + costs[1];
                int thirtyDayPass = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
            }
        }

        return dp[dp.length - 1];
    }
}
