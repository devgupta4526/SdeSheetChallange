import java.io.*;
import java.util.* ;

/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
		if(head == null){
			return null;
		}
		HashMap<LinkedListNode<Integer>,LinkedListNode<Integer>> map = 
		new HashMap<>();
		 LinkedListNode<Integer> clonedHead = new LinkedListNode<>(head.data);
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> clonedCurrent = clonedHead;
        map.put(current, clonedCurrent);

		while(current.next != null){
			clonedCurrent.next = new LinkedListNode<>(current.next.data);
			current = current.next;
			clonedCurrent = clonedCurrent.next;
			map.put(current,clonedCurrent);
		}
		current = head;
		clonedCurrent = clonedHead;
		while(current != null){
			clonedCurrent.random = map.get(current.random);
			current = current.next;
			clonedCurrent = clonedCurrent.next;
		}
		return clonedHead;
		
		
	}
}
