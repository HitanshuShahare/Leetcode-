class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        Arrays.sort(worker);

        int maxProfit = 0;
        int jobIndex = 0;
        int bestProfitSoFar = 0;
        int totalProfit = 0;

        for (int ability : worker) {
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                bestProfitSoFar = Math.max(bestProfitSoFar, jobs[jobIndex][1]);
                jobIndex++;
            }
            totalProfit += bestProfitSoFar;
        }
        return totalProfit;
    }
}