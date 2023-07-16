import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
		// int dp[][] = new int[n][w+1];
		// for(int row[] : dp)
		//    Arrays.fill(row,-1);
		// int ans = memeoization(values,weights,n-1,w,dp);
		// return ans;

		int dp[][] = new int[n][w + 1];

        for (int i = 0; i <= w; i++) {
            dp[0][i] = (weights.get(0) <= i) ? values.get(0) : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (weights.get(i) <= j) {
                    take = values.get(i) + dp[i - 1][j - weights.get(i)];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }

        return dp[n - 1][w];


	}

	public static int rec(ArrayList<Integer> values,ArrayList<Integer> weights , int i,  int w){
		if(i == 0){
			if(weights.get(i) <= w){
				return values.get(i);
			}
			return 0;
		}

		if(w <=0){
			return 0;
		}
	
		int notTake = 0 + rec(values,weights,i-1,w);
		int take = Integer.MIN_VALUE;
		if(weights.get(i) <= w){
			take = values.get(i) + rec(values, weights, i-1, w-weights.get(i));
		}
		return Math.max(notTake,take);
	}



	public static int memeoization(ArrayList<Integer> values,ArrayList<Integer> weights , int i,
	  int w , int dp[][]){
		if(i == 0){
			if(weights.get(i) <= w){
				return values.get(i);
			}
			return 0;
		}

		if(dp[i][w] != -1){
			return dp[i][w];
		}
	
		int notTake = 0 + rec(values,weights,i-1,w);
		int take = Integer.MIN_VALUE;
		if(weights.get(i) <= w){
			take = values.get(i) + rec(values, weights, i-1, w-weights.get(i));
		}
		return dp[i][w] = Math.max(notTake,take);
	}
}
