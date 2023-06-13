import java.io.*;
import java.util.* ;

public class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> list = new ArrayList<>();
        int n = arr.length;
        // Set<String> pairSet = new HashSet<>();
        // int n = arr.length;
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int sum = arr[i] + arr[j];
        //         if (sum == s) {
        //             int[] temp = {arr[i], arr[j]};
        //             Arrays.sort(temp);
        //             String pairKey = temp[0] + "," + temp[1];
        //             if (!pairSet.contains(pairKey)) {
        //                 list.add(temp);
        //                 pairSet.add(pairKey);
        //             }
        //         }
        //     }
        // }
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int num : arr){
            int rem = s - num;

            if(map.containsKey(rem)){
                for( int i = 0; i < map.get(rem); i++){
                    list.add(new int[]{Math.min(num,rem),Math.max(num,rem)});
                }
            }

            map.put(num,map.getOrDefault(num,0)+1);
        }
          

             Collections.sort(list, (a, b) -> {
        if (a[0] != b[0]) {
            return a[0] - b[0];
        } else {
            return a[1] - b[1];
        }
    });
           
        

        
        return list;
    }
}
