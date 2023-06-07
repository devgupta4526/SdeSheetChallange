import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long max = Long.MIN_VALUE;
		long sum = 0;
		for(int i = 0 ; i < n ; i++){
			sum = sum + arr[i];
			max = Math.max(max, sum);
			if(sum < 0){
				sum = 0;
			}
		}
		max = Math.max(max, sum);
		return max;
	}

}
