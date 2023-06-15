import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.
		int n = arr.size();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0; 

        for(int i = 0;i<n;i++) {

            sum += arr.get(i); 

            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(map.get(sum) != null) {

                    maxi = Math.max(maxi, i - map.get(sum)); 
                }
                else {

                    map.put(sum, i); 
                }
            }
        }
        return maxi; 
		
	}
	

}
