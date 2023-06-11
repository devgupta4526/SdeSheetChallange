import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int  finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/


public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        List<Interval> list = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        
            Interval curr = intervals[0];
            for(int j = 1 ; j < n ; j++){
                Interval inter = intervals[j];
                if(curr.finish >= inter.start){
                     curr.finish = Math.max(curr.finish, inter.finish);
                }
                else {
                 list.add(curr);
                curr = inter;
               }

            }
            list.add(curr);
            return list;
        
    

    }
}
