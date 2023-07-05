import java.util.* ;
import java.io.*; 
public class Solution {
    public static int atoi(String str) {
        // Write your code here.
        int ans = 0;
        int n = str.length();
        boolean negative = false;
        if(str.charAt(0) == '-'){
            negative = true;
            str = str.substring(1,n);
        }
        for(int i = n-1 ; i >= 0 ; i--){
            if(str.charAt(i) >='1' && str.charAt(i) <='9'){
                ans = ans*10 + (str.charAt(i) - '0');
            }
        }

        if(negative){
            return ans*-1;
        }
        return ans;
    }
}
