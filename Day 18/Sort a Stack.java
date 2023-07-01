import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
		if(stack.empty()){
			return;
		}
		int num =  stack.pop();
		sortStack(stack);
		insertSorted(stack, num);

	}



	public static void insertSorted(Stack<Integer> st , int num){
		if(st.empty() || st.peek() < num){
			st.push(num);
			return;
		}
		int x = st.pop();
		insertSorted(st, num);
		st.push(x);
	}

}
