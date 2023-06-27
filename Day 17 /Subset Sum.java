import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> ans = new ArrayList<>();
        int n = num.length;
        rec(num,ans,0,0);
        Collections.sort(ans);
        return ans;
    }

    public static void rec(int num[] , ArrayList<Integer> ans , int i , int sum){
       
        if(i == num.length){
            ans.add(sum);
            return;
        }
        rec(num, ans, i + 1, sum + num[i]);

        rec(num, ans, i + 1, sum);

      
    }

}
