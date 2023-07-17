import java.util.*;

public class Solution {

    public static long countWaysToMakeChange(int denominations[], int value) {
        // long dp[][] = new long[denominations.length][value + 1];
        // for (long[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // long ans = memoization(denominations, value, denominations.length - 1, dp);
        // return ans;

		 long dp[][]=new long[denominations.length][value+1];
    
    
    //Initializing base condition
    for(int i=0;i<=value;i++){
        if(i%denominations[0]==0)
            dp[0][i]=1;
    }
    
    for(int ind=1; ind<denominations.length;ind++){
        for(int target=0;target<=value;target++){
            long notTaken = dp[ind-1][target];
            
            long taken = 0;
            if(denominations[ind]<=target)
                taken = dp[ind][target-denominations[ind]];
                
            dp[ind][target] = notTaken + taken;
        }
    }
    
    return dp[denominations.length-1][value];
    }

    public static long rec(int denominations[], int value, int i) {
        if (i == 0) {
            if (value % denominations[0] == 0) {
                return 1;
            } else
                return 0;
        }

        long notPick = rec(denominations, value, i - 1);
        long pick = 0;
        if (denominations[i] <= value) {
            pick = rec(denominations, value - denominations[i], i);
        }

        return pick + notPick;
    }

    public static long memoization(int denominations[], int value, int i, long dp[][]) {
        if (i == 0) {
            if (value % denominations[0] == 0) {
                return 1;
            } else
                return 0;
        }
        if (dp[i][value] != -1) {
            return dp[i][value];
        }
        long notPick = memoization(denominations, value, i - 1, dp);
        long pick = 0;
        if (denominations[i] <= value) {
            pick = memoization(denominations, value - denominations[i], i, dp);
        }

        return dp[i][value] = pick + notPick;
    }
}
