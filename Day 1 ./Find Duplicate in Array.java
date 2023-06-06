import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        // Collections.sort(arr);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < n ;i++){
            // if(arr.get(i) == arr.get(i+1)){
            //     return arr.get(i);
            // }
            if(set.contains(arr.get(i))){
                return arr.get(i);
            }
            else{
                set.add(arr.get(i));
            }
        }
       return 0;

    }
}
