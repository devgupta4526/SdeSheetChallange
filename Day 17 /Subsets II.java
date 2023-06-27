import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(arr);
        rec(0, arr, new ArrayList<>(), ans); 
        // Collections.sort(ans, new SubsetComparator());

        return ans;
    }

    // public static void rec(int i , int n , 
    //  ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> temp, int arr[]){
    //     if(i == n){
    //             Collections.sort(temp);
    //         if (!isListPresent(ans, temp)) {
    //             ans.add(new ArrayList<>(temp));
    //         }
    //         return;
    //     }
    //     temp.add(arr[i]);
    //     rec(i+1, n, ans, temp, arr);

    //     temp.remove(temp.size()-1);

    //     rec(i+1, n, ans, temp, arr);
    // }

    //  public static boolean isListPresent(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
    //     for (ArrayList<Integer> subset : ans) {
    //         if (subset.size() == list.size() && subset.containsAll(list)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    //   public static class SubsetComparator implements Comparator<ArrayList<Integer>> {
    //     @Override
    //     public int compare(ArrayList<Integer> subset1, ArrayList<Integer> subset2) {
    //         if (subset1.size() != subset2.size()) {
    //             return subset1.size() - subset2.size();
    //         }
    //         for (int i = 0; i < subset1.size(); i++) {
    //             int diff = subset1.get(i) - subset2.get(i);
    //             if (diff != 0) {
    //                 return diff;
    //             }
    //         }
    //         return 0;
    //     }
    // }

      public static void rec(int ind, int[] nums, List<Integer> ds, ArrayList<ArrayList<Integer>> ansList) {
       ansList.add(new ArrayList<>(ds)); 
       for(int i = ind;i<nums.length;i++) {
           if(i!=ind && nums[i] == nums[i-1]) continue; 
           ds.add(nums[i]); 
           rec(i+1, nums, ds, ansList); 
           ds.remove(ds.size() - 1);
       }
       
   }



}
