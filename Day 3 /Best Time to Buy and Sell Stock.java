import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        // int max = 0;
        // for(int i = 0 ; i < prices.size() ; i++){
        //     for(int j = i + 1  ; j < prices.size(); j++){
        //         if(prices.get(j) > prices.get(i))
        //         max = Math.max(max , prices.get(j) - prices.get(i));
        //     }
        // }
        // return max;

        int max  = 0 ;
        int min = Integer.MAX_VALUE;
        int n = prices.size();
        for(int i = 0 ; i < n ; i++){
            if(min > prices.get(i)){
                min = prices.get(i);
            }
            int val = prices.get(i) - min;
            max = Math.max(val, max);
        }
        return max;
    } 
}
