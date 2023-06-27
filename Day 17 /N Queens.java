import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        NQueen(ans, 0, 0, n, new boolean[n][n]);

        return ans;
    }

    public static void NQueen(ArrayList<ArrayList<Integer>> ans, int row, int qpsf, int tq, boolean[][] board) {
        if (qpsf == tq) {
            ans.add(construct(board, row));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isItSafeToPlaceTheQueen(board, row, col)) {
                board[row][col] = true;
                NQueen(ans, row + 1, qpsf + 1, tq, board);
                board[row][col] = false;
            }
        }
    }

    public static ArrayList<Integer> construct(boolean[][] board, int row) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j])
                    res.add(1);
                else
                    res.add(0);
            }
        }

        return res;
    }

    public static boolean isItSafeToPlaceTheQueen(boolean[][] board, int row, int col) {
        // vertically upward
        int r = row - 1;
        int c = col;

        while (r >= 0) {
            if (board[r][c])
                return false;
            r--;
        }

        // horizontally left
        r = row;
        c = col - 1;

        while (c >= 0) {
            if (board[r][c])
                return false;
            c--;
        }

        // diagonally left - upward
        r = row - 1;
        c = col - 1;

        while (r >= 0 && c >= 0) {
            if (board[r][c])
                return false;
            c--;
            r--;
        }

        // diagonally right - upward
        r = row - 1;
        c = col + 1;

        while (r >= 0 && c < board[0].length) {
            if (board[r][c])
                return false;
            c++;
            r--;
        }

        return true;
    }

}
