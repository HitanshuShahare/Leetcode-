import java.util.*;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i < 10; i++) {
            int next = current * 10 + i;
            if (next > n) {
                break;
            }
            dfs(next, n, result);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 20;
        System.out.println(sol.lexicalOrder(n));
        // lexo Graphical order : [1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
