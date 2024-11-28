class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                sum += Math.abs(value);
                minAbs = Math.min(minAbs, Math.abs(value));
                if (value < 0) negativeCount++;
            }
        }

        return negativeCount % 2 == 0 ? sum : sum - 2L * minAbs;
    }
}