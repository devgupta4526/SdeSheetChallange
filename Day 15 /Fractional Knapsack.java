import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
			double profit = 0;
          Arrays.sort(items,new Comparator<Pair>(){
           public int compare(Pair i1, Pair i2) {
               return i2.value*i1.weight - i2.weight * i1.value;
           }
       });
        int currW = 0;
        for (int i = 0; i < n; i++) {
            if (currW + items[i].weight <= w) {
                currW = currW + items[i].weight;
                profit = profit + (double) items[i].value;
            } else {
                int remain = w - currW;
                profit = profit + ((double) items[i].value / (double) items[i].weight) * (double) remain;
                break;
            }
        }
        return profit;


    }
}
