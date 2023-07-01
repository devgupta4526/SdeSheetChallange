import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(arr.get(n - 1));
        ans.add(-1);
        
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr.get(i)) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(st.peek());
            }
            
            st.push(arr.get(i));
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
