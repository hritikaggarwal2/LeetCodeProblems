class Solution {
    
    private int findCount(int[][] obstacleGrid, int[][] store, int i, int j) {
        if (i < 0 ||
            j < 0 ||
            i >= obstacleGrid.length ||
            j >= obstacleGrid[0].length ||
            obstacleGrid[i][j] == 1 ||
            store[i][j] == -1) {
            return 0;
        }
        
        if (store[i][j] > 0) {
            return store[i][j];
        }
        
        int down = findCount(obstacleGrid, store, i + 1, j);
        int right = findCount(obstacleGrid, store, i, j + 1);
        
        if (down + right == 0) {
            store[i][j] = -1;
        } else {
            store[i][j] = down + right;
        }
        
        return down + right;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] store = new int[m][n];
        
        store[m - 1][n - 1] = 1;
        
        return findCount(obstacleGrid, store, 0, 0);
    }
}