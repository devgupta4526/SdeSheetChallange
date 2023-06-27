import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        // Write your code here.\
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        rec(0,k,arr,new ArrayList<>(), list);
        return list;
    }

    public static void rec(int i , int sum , ArrayList<Integer> arr , 
    ArrayList<Integer> temp , ArrayList<ArrayList<Integer>> ans){
         if(i == arr.size()){
             if(sum == 0){
                 ans.add(new ArrayList<>(temp));
             }
             return;
         }

        
             temp.add(arr.get(i));
             rec(i + 1, sum - arr.get(i), arr, temp, ans);
             temp.remove(temp.size() -1);
         
         rec(i + 1, sum, arr, temp, ans);
     }
}
