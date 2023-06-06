import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        int n = mat.size();
        int m = mat.get(0).size();
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         if(target == mat.get(i).get(j)){
        //             return true;
        //         }
        //     }
        // }
        int start = 0;
        int end = n*m -1 ;
        while(start <= end){
            int mid = start + (end - start)/2;
            int col = mid%m;
            int row = mid/m;
            int val = mat.get(row).get(col);
            if(val == target){
                return true;
            }
             if(val < target){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }

        }
        return false;
    }
}
