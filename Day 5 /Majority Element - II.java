import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.size();
        for(int a : arr){
            if(map.containsKey(a)){
                int val = map.get(a);
                map.put(a, val + 1);
            }
            else{
                map.put(a,1);
            }
        }
        for(int a : arr){
            if(map.get(a) > n/3)
             if(!list.contains(a))
              list.add(a);
        }
        return list;
    }
}
