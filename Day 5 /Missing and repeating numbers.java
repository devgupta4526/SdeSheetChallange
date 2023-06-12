import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
       HashMap<Integer,Integer> map = new HashMap<>();
       int [] ans = new int[2];
       for(int a : arr){
           if(map.containsKey(a)){
               int count = map.get(a);
               map.put(a,count+1);
           }
           else{
               map.put(a, 1);
           }
       }

       for(int i =1 ; i <= arr.size(); i++){
           if(!map.containsKey(i)){
               ans[0] = i;
           }
           else if(map.get(i) > 1){
               ans[1] = i;
           }
       }

       return ans; 
       
    }
}
