import java.util.*;

public class Solution {
    public static List< Integer > stringMatch(String text, String pattern){
        // Write your code here.
        List<Integer> list = new ArrayList<>();
        int n = text.length();
        for(int i = 0 ; i < n ; i++){
            if(text.charAt(i) == pattern.charAt(0)){
                int start = 0;
                int startText = i;
                int end = pattern.length()-1;
                while(start <= end && startText != n){
                    if(text.charAt(startText) != pattern.charAt(start)){
                        break;
                    }
                    start++;
                    startText++;
                }
                if(start > end){
                    list.add(i+1);
                }
            }
        }
        return list;
    }
}
