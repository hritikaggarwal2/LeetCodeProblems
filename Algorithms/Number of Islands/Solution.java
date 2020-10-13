class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int x = grid.length;
        int y = grid[0].length;
        int count = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        if (i - 1 >= 0) {
            dfs(grid, i - 1, j);
        }

        if (j - 1 >= 0) {
            dfs(grid, i, j - 1);
        }

        if (i + 1 < grid.length) {
            dfs(grid, i + 1, j);
        }

        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1);
        }
    }

}