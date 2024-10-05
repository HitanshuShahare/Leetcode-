import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int n = skill.length;
        long totalChemistry = 0;
        int targetSum = skill[0] + skill[n - 1];

        for (int i = 0; i < n/2; i++) {
            int sum = skill[i] + skill[n - i - 1];
            if (sum != targetSum) {
                return -1;
            }
            totalChemistry += (long) skill[i] * skill[n - i - 1];
        }
        return totalChemistry;
    }
}