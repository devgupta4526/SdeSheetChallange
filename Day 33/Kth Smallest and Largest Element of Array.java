import java.util.ArrayList;

import java.util.Collections;

 

public class Solution {

    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {

        //Write your code here

        Collections.sort(arr);

        

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(arr.get(k-1));

        Collections.reverse(arr);

        ans.add(arr.get(k-1));

        return ans;

    }

}
