import java.util.*;

public class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Priority queue for 0-1 BFS
        Deque<int[]> deque = new LinkedList<>();
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        // Start from the top-left corner
        deque.addFirst(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0], y = current[1];

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int cost = dist[x][y] + grid[nx][ny];
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        if (grid[nx][ny] == 0) {
                            deque.addFirst(new int[]{nx, ny}); // Prioritize empty cells
                        } else {
                            deque.addLast(new int[]{nx, ny}); // Handle obstacles later
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
