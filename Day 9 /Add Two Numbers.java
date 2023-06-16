import java.util.*;
import java.io.*;

/****************************************************************
Following is the class structure of the Node class:

class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}
*****************************************************************/

public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Create a dummy node to store the result
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode temp = dummy;
        
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = carry;
            
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            
            carry = sum / 10; // Calculate carry
            
            // Create a new node with the sum % 10 as data
            LinkedListNode newNode = new LinkedListNode(sum % 10);
            
            // Connect the new node to the result list
            temp.next = newNode;
            temp = temp.next;
        }
        
        // Check if there is any remaining carry
        if (carry > 0) {
            temp.next = new LinkedListNode(carry);
        }
        
        return dummy.next;
    }
}
