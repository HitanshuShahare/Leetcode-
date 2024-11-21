class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = -1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -2;
        }
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            mark(grid, x, y, 0, 1);
            mark(grid, x, y, 0, -1);
            mark(grid, x, y, 1, 0);
            mark(grid, x, y, -1, 0);
        }
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
    }

    private void mark(int[][] grid, int x, int y, int dx, int dy) {
        int m = grid.length, n = grid[0].length;
        x += dx;
        y += dy;
        while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -1 && grid[x][y] != -2) {
            if (grid[x][y] == 0) {
                grid[x][y] = 1;
            }
            x += dx;
            y += dy;
        }
    }
}
