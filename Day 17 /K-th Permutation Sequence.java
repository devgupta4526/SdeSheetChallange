import java.util.ArrayList;
import java.util.*;
public class Solution {
    public static String kthPermutation(int n, int k) {
        // Write your code here.
        // ArrayList<String> list = new ArrayList<>();
        // String str = "";
        // for(int i = 1 ; i <= n ; i++){
        //     str = str + i;
        // }
        // rec(0,str.toCharArray(),n,list);
        // Collections.sort(list);
        // return list.get(k-1);

        int fact = 1;
        ArrayList < Integer > numbers = new ArrayList < > ();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans = ans + "" + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;

    }

    public static void rec(int index , char [] str , int n , ArrayList<String> list){
        if(index == n){
            String s = new String(str);
            list.add(s);
            return;
        }

        for(int i = index ; i < n ; i++){
            swap(str, i, index);
            rec(index + 1, str, n, list);
            swap(str, i, index);
        }
    }

     static void swap(char s[], int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}
