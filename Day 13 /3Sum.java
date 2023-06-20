import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

	    // Write your code here.
		// Arrays.sort(arr);
		// ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		// for(int i = 0 ; i < n-2 ; i++){
		// 	 if (i > 0 && arr[i] == arr[i - 1]) {
        //         continue; 
        //     }
		// 	int j = i+1;
		// 	int k = n-1;
		// 	while(j<k){
		// 		int sum = arr[i] + arr[j] + arr[k];
		// 		if(sum == K){
		// 			ArrayList<Integer> list = new ArrayList<>();
		// 			list.add(arr[i]);
		// 			list.add(arr[j]);
		// 			list.add(arr[k]);
		// 			if(!ans.contains(list))
		// 			     ans.add(list);
		// 			   // Skip duplicate elements
        //             while (j < k && arr[j] == arr[j + 1]) {
        //                 j++;
        //             }
        //             while (j < k && arr[k] == arr[k - 1]) {
        //                 k--;
        //             }
		// 			 j++;
        //             k--;
		// 		}
		// 		else if(sum >K){
		// 			k--;
		// 		}
		// 		else{
		// 			j++;
		// 		}
		// 	}
		// }
		// return ans;


		// Arrays.sort(arr);
        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // for (int i = 0; i < n - 2; i++) {
        //     if (i > 0 && arr[i] == arr[i - 1]) {
        //         continue; // Skip duplicate elements
        //     }

        //     int target = K - arr[i];
        //     HashSet<Integer> seen = new HashSet<>();

        //     for (int j = i + 1; j < n; j++) {
        //         int complement = target - arr[j];
        //         if (seen.contains(complement)) {
        //             ArrayList<Integer> triplet = new ArrayList<>();
        //             triplet.add(arr[i]);
        //             triplet.add(arr[j]);
        //             triplet.add(complement);
        //             ans.add(triplet);

        //             while (j + 1 < n && arr[j] == arr[j + 1]) {
        //                 j++; // Skip duplicate elements
        //             }
        //         }
        //         seen.add(arr[j]);
        //     }
        // }

        // return ans;
		  Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue; // Skip duplicate elements
            }

            int target = K - arr[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    ans.add(triplet);

                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++; // Skip duplicate elements
                    }
                    while (left < right - 1 && arr[right] == arr[right - 1]) {
                        right--; // Skip duplicate elements
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;

	}
}
