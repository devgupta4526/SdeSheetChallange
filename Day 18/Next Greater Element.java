import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here
		int [] ans = new int[n];
		Stack<Integer> st = new Stack<>();
		st.push(arr[n-1]);
		ans[n-1] = -1;
		for(int i = n-1 ;i >=0 ;i--){
			 while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            
            st.push(arr[i]);
		}
		return ans;
		
	}

}
