import java.util.Stack;

public class Queue {
    // Define the data members(if any) here.

    Stack<Integer> st ;
    Stack<Integer> rt;
    Queue() {
        // Initialize your data structure here.
        st = new Stack<>();
        rt = new Stack<>();
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        st.push(val);
    }

    int deQueue() {
        // Implement the dequeue() function.
        if(isEmpty()){
            return -1;
        }
        while(!st.isEmpty()){
            rt.push(st.pop());
        }
       int ele = rt.pop();
        while(!rt.isEmpty()){
            st.push(rt.pop());
        }
        return ele;
    }

    int peek() {
        // Implement the peek() function here.
         if(isEmpty()){

            return -1;

        }
         while(!st.isEmpty()){
            rt.push(st.pop());
        }
        int ele = rt.peek();
        while(!rt.isEmpty()){
            st.push(rt.pop());
        }
        return ele;
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}
