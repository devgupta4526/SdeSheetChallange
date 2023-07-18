import java.util.*;

public class Solution {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = image[i][j];
            }
        }

        int originalColor = mat[x][y];
        if (originalColor == newColor) {
            // If the new color is the same as the original color, no need to do anything.
            return mat;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair node = q.remove();
            int i = node.x;
            int j = node.y;

            // Check if the current pixel is within bounds and has the original color
            if (i >= 0 && j >= 0 && i < n && j < m && mat[i][j] == originalColor) {
                // Update the color of the current pixel
                mat[i][j] = newColor;

                // Add the neighboring pixels with the original color to the queue
                q.add(new Pair(i - 1, j));
                q.add(new Pair(i, j - 1));
                q.add(new Pair(i + 1, j));
                q.add(new Pair(i, j + 1));
            }
        }

        return mat;
    }
}
