import java.util.*;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            int flip = row[0];
            for (int num : row) {
                pattern.append(num ^ flip);
            }
            String key = pattern.toString();
            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
        }
        return Collections.max(patternCount.values());
    }
}
