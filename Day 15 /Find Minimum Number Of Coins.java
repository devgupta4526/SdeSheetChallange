import java.util.* ;
import java.io.*; 
public class Solution
{
public static int findMinimumCoins(int amount)
    {
        // Write your code here.
        int coins[] = {1000,500,100,50,20,10,5,2,1};
        int count = 0;
        int n = coins.length;
        for(int i = 0 ; i < n ; i++){
            while(amount - coins[i] >= 0){
                amount = amount - coins[i];
                count++;
            }
        }
        return count;
    }
}
