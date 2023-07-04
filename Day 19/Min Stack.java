import java.util.* ;
import java.io.*; 

public class Solution {

   static class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

    static class MinStack {
        Stack < Pair > st;

        // Constructor
        MinStack() {
            // Write your code here.
            st = new Stack<>();

        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            // Write your code here.
            int min;
            if(st.isEmpty()){
                min = num;
                st.push(new Pair(num, min));
            }
            else{
                min = Math.min(st.peek().y, num);
                st.push(new Pair(num, min));
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            // Write your code here.
            if (st.isEmpty()) {
                    return -1;
                }
            return st.pop().x;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            // Write your code here.
             if (st.isEmpty()) {
                    return -1;
                }
            return st.peek().x;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            // Write your code here.
            if (st.isEmpty()) {
                return -1;
            }
            return st.peek().y;
        }
    }
}
