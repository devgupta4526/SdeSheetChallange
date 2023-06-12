import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int dp[][] = new int[m][n];
		for(int row[] : dp)
		    Arrays.fill(row,-1);
		return rec( m-1,n-1,m , n , dp);
	}
	public static int rec(int i , int j ,int m 
	, int n , int [][] dp){
		if(i == 0 && j ==0){
			return 1;
		}
		if(i<0 || j<0){
			return 0;
		} 
		if(dp[i][j] != -1)
		   return dp[i][j];
		int up = rec(i,j-1,m,n,dp);
		int left = rec(i-1,j,m,n,dp);
		return dp[i][j]= up + left;
	}

}
