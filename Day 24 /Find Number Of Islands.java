public class Solution {
    public static int getTotalIslands(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int visited[][] = new int[m][n];
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && visited[i][j] == 0){
                    dfs(mat, visited, directions, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] mat, int[][] visited, int directions[][], int row, int col){
        visited[row][col] = 1;
        for(int i = 0; i < directions.length; i++){
            int nrow = row + directions[i][0];
            int ncol = col + directions[i][1];
            if(nrow >= 0 && nrow < mat.length && ncol >= 0 && ncol < mat[0].length
               && visited[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
                dfs(mat, visited, directions, nrow, ncol);
            }
        }
    }
}
