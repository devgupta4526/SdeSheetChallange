import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        if (maze[0][0] == 0) {
            return list;
        }

        int path[][] = new int[n][n];
        allPath(maze, n, path, list, 0, 0);

        return list;
    }

    private static void allPath(int[][] maze, int n, int[][] path, ArrayList<ArrayList<Integer>> list,
            int row, int col) {

        path[row][col] = 1;

        if (row == n - 1 && col == n - 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path.length; j++) {
                    ans.add(path[i][j]);
                }
            }
            list.add(ans);
            path[row][col] = 0;
            return;
        }

        // Down
        if (pathIsPossible(row + 1, col, maze, path)) {
            allPath(maze, n, path, list, row + 1, col);
        }

        // Left
        if (pathIsPossible(row, col - 1, maze, path)) {
            allPath(maze, n, path, list, row, col - 1);
        }

        // Right
        if (pathIsPossible(row, col + 1, maze, path)) {
            allPath(maze, n, path, list, row, col + 1);
        }

        // Up
        if (pathIsPossible(row - 1, col, maze, path)) {
            allPath(maze, n, path, list, row - 1, col);
        }

        path[row][col] = 0;
    }

    private static boolean pathIsPossible(int row, int col, int[][] maze, int[][] path) {
        int n = maze.length;

        if (row >= n || col >= n || row < 0 || col < 0 || maze[row][col] == 0 || path[row][col] == 1) {
            return false;
        }

        return true;
    }
}
