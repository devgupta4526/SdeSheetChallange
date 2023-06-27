import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> list = new ArrayList<>();
        rec(0,s.toCharArray(),list);
        return list;
    }

    public static void rec(int i , char [] s , List<String> list){
        if(i == s.length){
            String str = new String(s);
            list.add(str);
            return;
        }
        for(int index = i ; index < s.length ; index++){
            swap(s,index, i );
            rec( i + 1, s, list);
            swap(s,index, i );
        }
    }

    public static void swap( char [] s , int i , int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
