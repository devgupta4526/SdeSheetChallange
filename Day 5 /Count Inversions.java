import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long count = 0 ; 
        // for(int i = 0 ; i < n ; i++){
        //     for(int j =i +1 ; j<n; j++){
        //         if(arr[i] > arr[j] && (i<j))
        //           count++;
        //     }
        // }
        
        return mergeSort(arr, 0, n-1 );
    }

    public static long mergeSort(long[] arr, int low, int  high){
        long count = 0;
        if(low>=high){
            return count;
        }
        int mid = (low + high)/2;
        count += mergeSort(arr,low,mid);
        count += mergeSort(arr,mid + 1,high);
        count += merge(arr,low,mid,high);
        return count;

    }

    public static long merge(long[] arr, int low, int mid, int high) {
    ArrayList<Long> list = new ArrayList<>();
    int left = low;
    int right = mid + 1;
    long count = 0;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            list.add(arr[left]);
            left++;
        } else {
            list.add(arr[right]);
            count += (mid - left + 1);
            right++;
        }
    }

    while (left <= mid) {
        list.add(arr[left]);
        left++;
    }

    while (right <= high) {
        list.add(arr[right]);
        right++;
    }

    for (int i = low; i <= high; i++) {
        arr[i] = list.get(i - low);
    }

    return count;
}

}
