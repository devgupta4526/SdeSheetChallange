import java.util.*;

public class Stack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Stack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public int getSize() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void push(int element) {
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1.add(element);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }


}
