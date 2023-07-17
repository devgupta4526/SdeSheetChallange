import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        // Write your code here.
        // int ans = rec(rack,0,-1,n);
        int ans = memoization(rack, 0, -1, n, new int[n + 1][n + 1]);
        // int ans = tabulation(rack, n);
        return ans;
    }

     public static int memoization(ArrayList<Integer> arr, int i, int last, int n, int[][] memo) {
        if (i == n) {
            return 0;
        }

        if (memo[i][last + 1] != 0) {
            return memo[i][last + 1];
        }

        int pick = 0;
        if (last == -1 || arr.get(i) > arr.get(last)) {
            pick = arr.get(i) + memoization(arr, i + 1, i, n, memo);
        }

        int notPick = memoization(arr, i + 1, last, n, memo);

        memo[i][last + 1] = Math.max(pick, notPick);
        return memo[i][last + 1];
    }


    public static int tabulation(ArrayList<Integer> rack, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int last = 0; last <= n; last++) {
                int pick = 0;
                if (i > 0 && (last == 0 || rack.get(i - 1) > rack.get(last - 1))) {
                    pick = rack.get(i - 1) + dp[i - 1][i];
                }

                int notPick = dp[i][last - 1];

                dp[i][last] = Math.max(pick, notPick);
            }
        }

        return dp[n][n];
    }
    public static int rec(ArrayList<Integer> arr , int i,int last,int n){
		if(i == n){
			return 0;
		}
		int pick =0;
		if(last == -1 || arr.get(i) > arr.get(last))
		    pick = arr.get(i) + rec(arr,i+1,i,n);
	    
		int notPick = 0 + rec(arr,i+1,last,n);

		return Math.max(pick,notPick);
		
	}
}
