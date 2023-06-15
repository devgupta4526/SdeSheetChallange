import java.io.*;
import java.util.* ;

/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		  if(head == null){
				return null;
			}
    if(head.next == null){
        return head;
    }
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> nexx = head.next;
		while( curr!= null){
			  curr.next = prev;
			  prev = curr;
			  curr = nexx;
			  if(nexx!= null ){
				  nexx = nexx.next;
			  }



		}
		return prev;
		
    }
}
