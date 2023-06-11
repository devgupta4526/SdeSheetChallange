import java.io.*;
import java.util.* ;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        // for(int i = m , j = 0 ; i < m + n || j < n ; i++, j++){
        //     arr1[i] = arr2[j]; 
        // }
        // Arrays.sort(arr1);
        // return arr1;
        int [] merge = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<m && j<n){
            if(arr1[i] <= arr2[j]){
                merge[k] = arr1[i];
                i++;
               
            }
           else{
                merge[k] = arr2[j];
                j++;
              
            }
             k++;
        }
        while(j<n){
            merge[k] = arr2[j];
            j++;
            k++;
        }
         while(i<m){
            merge[k] = arr1[i];
            i++;
            k++;
        }
        return merge;
    }
}
