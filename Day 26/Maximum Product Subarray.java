import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
		int result = arr.get(0);
        int maxEndingHere = arr.get(0);
        int minEndingHere = arr.get(0);

        for (int i = 1; i < n; i++) {
            int current = arr.get(i);

            if (current < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(current, current * maxEndingHere);
            minEndingHere = Math.min(current, current * minEndingHere);

            result = Math.max(result, maxEndingHere);
        }

        return result;

	}

	
}
