import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        // Handle base cases
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
        LinkedListNode<Integer> current = dummy;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        // Attach remaining nodes from either list
        if (first != null) {
            current.next = first;
        }
        if (second != null) {
            current.next = second;
        }

        return dummy.next;
    }


}
