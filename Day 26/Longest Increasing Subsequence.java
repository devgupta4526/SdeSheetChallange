import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
		int dp[][] = new int[arr.length + 1][arr.length + 1];
		for(int row [] : dp){
			Arrays.fill(row , -1);
		}
		int ans = memoization(arr, 0, -1,dp);

		// int dp[] = new int[arr.length];
		// int ans = 0;
		// for (int i = 0; i < arr.length; i++) {
        //     dp[i] = 1;
        //  }
		// for(int i = 1; i < arr.length ; i++){
		// 	for(int j = 0; j < i ; j++){
		// 		if(arr[j] < arr[i]){
		// 			dp[i] = Math.max(dp[i], dp[j] + 1);
		// 		}
		// 	}
		// 	ans = Math.max(ans, dp[i]);
		// }
		return ans;
	}

	public static int rec(int arr[] , int i,int last){
		if(i == arr.length){
			return 0;
		}
		int pick =0;
		if(last == -1 || arr[i] > arr[last])
		    pick = 1 + rec(arr,i+1,i);
	    
		int notPick = 0 + rec(arr,i+1,last);

		return Math.max(pick,notPick);
		
	}

	public static int memoization(int arr[] , int i,int last , int dp[][]){
		if(i == arr.length){
			return 0;
		}
		if(dp[i][last+1] != -1){
			return dp[i][last+1];
		}

		int notPick = 0 + memoization(arr,i+1,last,dp);

		int pick =0;
		if(last == -1 || arr[i] > arr[last])
		    pick = 1 + memoization(arr,i+1,i,dp);
	    
		
		return dp[i][last+1] = Math.max(pick,notPick);
		
	}

}
