import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);
        int count =1;
        int dept = 0;
        for(int i = 0 ; i < n ; i++){
            if(at[i] > dt[dept] ){
                dept++;
            }
            else{
                count++;
            }
        }
        return count-1;
        
    }
}
