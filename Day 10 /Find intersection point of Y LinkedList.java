import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
        LinkedListNode <Integer>first = firstHead;
        LinkedListNode <Integer>second = secondHead;
        
        while(first!=second){
        if(first==null)
            first=secondHead;
        else
            first=first.next;
        if(second==null)
            second=firstHead;
        else
            second=second.next;
    }if(first==null)
        return -1;
    else{
        return first.data;
    }
        

		
	}
}
