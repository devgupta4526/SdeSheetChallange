import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = price.size();
        for(int i = 0; i < n ; i++){
            int count = 0;
            while(!st.isEmpty() && price.get(st.peek()) <= price.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(i+1);
            }
            else{
                ans.add(i-st.peek());
            }
            st.push(i);
        }
        return ans;
    }
}
