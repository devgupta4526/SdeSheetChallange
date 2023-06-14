import java.io.*;
import java.util.* ;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        Arrays.sort(arr);
        int count = 1; 
        int max = 1;
        for(int i = 0 ; i< N-1 ;i++){
            if(arr[i]+1 == arr[i+1])
            {
                count++;
                max = Math.max(max, count);
            }
            else if(arr[i] == arr[i+1]){
                continue;
            }
            else{
                count =1;
            }

        }
        return max;
    }
}
