import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {

	    // Define the getListAfterReverseOperation function
    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        // If the linked list is empty, return null
        if (head == null)
            return null;

        // Initialize necessary variables
        Node node = head; // Pointer to traverse the linked list
        Node current = node; // Pointer to keep track of the current node during reverse operation
        Node Cp = null; // Pointer to keep track of the last node after each reverse operation
        boolean flag = true; // Flag to indicate the first reverse operation
        Node nfirst = node; // Pointer to keep track of the new head node of the linked list

        // Loop through each length 'len' in the array 'b[]'
        for (int len : b) {
            // If 'current' becomes null, exit the loop
            if (current == null)
                break;

            // If 'len' is less than 1, skip this iteration (no reverse operation for length < 1)
            if (len < 1)
                continue;

            // Reverse the current segment of length 'len'
            Node prev = null;
            Node next = null;
            Node last = null;

            // Traverse 'len' nodes and reverse the pointers
            while (current != null && len-- > 0) {
                next = current.next;
                current.next = prev;
                prev = current;
                last = current; // 'last' points to the last node of the reversed segment
                current = next;
            }

            // Update 'node' to point to the first node of the reversed segment
            node = prev;

            // Link the previous reversed segment to the newly reversed segment
            while (Cp != null && Cp.next != null)
                Cp = Cp.next;
            if (Cp != null)
                Cp.next = prev;
            Cp = last; // 'Cp' points to the last node of the current reversed segment

            // If this is the first reverse operation, update 'nfirst' to the new head node
            if (flag) {
                nfirst = node;
                flag = false; // Set 'flag' to false to indicate that the first operation is done
            }
        }

        // Link the remaining part of the original list to the last node of the last reversed segment
        if (current != null) {
            while (Cp != null && Cp.next != null)
                Cp = Cp.next;
            if (Cp != null)
                Cp.next = current;
        }

        // Return the new head of the linked list after all the reverse operations
        return nfirst;
    }
}
