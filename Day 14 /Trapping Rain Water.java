import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        // Write your code here.
        long sum = 0;
        long maxLeft = 0;
        long maxRight = 0;
        int left = 0;
        int right = n -1;
        while(left <= right){
            if(arr[left] <= arr[right]){
                if(arr[left] >= maxLeft){
                    maxLeft = arr[left];
                }
                else{
                    sum = sum + maxLeft - arr[left];
                }
                left++;
            }
            else{
                if(arr[right] >= maxRight){
                    maxRight = arr[right];
                }
                else{
                    sum = sum + maxRight - arr[right];
                }
                right--;
            }
           
        }
         return sum;
    }
}
