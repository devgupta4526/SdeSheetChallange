import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        char s1[] = str1.toCharArray();
        char s2[] = str2.toCharArray();
        int n = str1.length();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i = 0 ; i < n ; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }
}
