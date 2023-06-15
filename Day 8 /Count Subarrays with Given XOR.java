import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
		int n = arr.size();
		// int count = 0;
		// for(int i = 0 ; i < n ; i++){
		// 	int xor = 0;
		// 	for(int j = i ; j < n ; j++){
		// 			xor = xor ^ arr.get(j);
				
		// 		if(xor == x){
		// 			count++;
		// 		}
		// 	}
		// }
		// return count;
		int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ arr.get(i);

            //By formula: x = xr^k:
            int xor = xr ^ x;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(xor)) {
                cnt += mpp.get(xor);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
	}
}
