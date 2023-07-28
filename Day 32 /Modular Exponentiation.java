import java.io.*;
import java.util.* ;

public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here. 
        // long mul = 1;
        // for(int i = 0 ; i < n ; i++){
        //     mul = (x%m * mul%m)%m;
        // } 
        // return (int)mul%m;
        long result = 1;
        long base = x % m;
        
        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * base) % m;
            }
            base = (base * base) % m;
            n /= 2;
        }
        
        return (int) result;
    } 
    }

