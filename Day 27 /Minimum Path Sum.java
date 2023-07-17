import java.util.Arrays;

public class Solution {
    public static int minSumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return minSumPathUtil(m - 1, n - 1, grid, dp);
    }

    static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }
        
        if (i < 0 || j < 0) {
            return (int) 1e9;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
            
        int up = matrix[i][j] + minSumPathUtil(i - 1, j, matrix, dp);
        int left = matrix[i][j] + minSumPathUtil(i, j - 1, matrix, dp);
        
        return dp[i][j] = Math.min(up, left);
    }
}
