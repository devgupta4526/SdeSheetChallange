import java.util.* ;
import java.io.*; 
public class Solution {
    public static int romanToInt(String s) {
        // Write your code here
        int n = s.length();
        int prev = s.charAt(n-1);
        int ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        for(int i = n-1 ; i >=0 ; i++){
            if(prev <= mp.get(s.charAt(i))){
                ans = ans + mp.get(s.charAt(i));
                prev = mp.get(s.charAt(i));
            }
            else{
                if(prev > mp.get(s.charAt(i))){
                    ans = ans - mp.get(s.charAt(i));
                }
            }
        }

        return ans;

    }
}
