import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		// Write your code here!
		// LinkedListNode<Integer> slow = head;
		// LinkedListNode<Integer> fast = head;
		// Stack<Integer> st = new Stack<>();
		// while(fast != null && fast.next != null){
		// 	st.push(slow.data);
		// 	slow = slow.next;
		// 	fast = fast.next.next;
		// }
		
		// if(fast != null){
		// 	slow = slow.next;
		// }
		// while(slow != null){
		// 	if(slow.data != st.pop()){
		// 		return false;
		// 	}
		// 	slow = slow.next;
		// }
		// return true;
	  LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // if (fast != null) {
        //     slow = slow.next;
        // }
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = slow;
        while (curr != null) {
            LinkedListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        LinkedListNode<Integer> check = head;
		LinkedListNode<Integer> slow1 = prev;
        while (slow1 != null) {
            if (!slow1.data.equals(check.data)) {
                return false;
            }
            slow1 = slow1.next;
            check = check.next;
        }
        return true;
	}
}
