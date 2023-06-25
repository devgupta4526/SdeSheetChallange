import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
        int n = start.length;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(i+1);
            temp.add(start[i]);
            temp.add(end[i]);
            arr.add(temp);
        }
        Collections.sort(arr, (a,b)-> Integer.compare(a.get(2), b.get(2)));
         int id = arr.get(0).get(0);
            int s = arr.get(0).get(1);
            int e = arr.get(0).get(2);
            list.add(id);
        for(int i = 1 ; i < n ; i++){
           if(e < arr.get(i).get(1)){
               list.add(arr.get(i).get(0));
                e = arr.get(i).get(2);
           }
        }
        return list;

    }
}
