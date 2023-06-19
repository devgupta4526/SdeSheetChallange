/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        Node end = head;
        int count = 1;
        while (end.next != null) {
            end = end.next;
            count++;
        }

        k = k % count;
        if (k == 0) {
            return head; // No rotations needed
        }

        Node curr = head;
        for (int i = 0; i < count - k - 1; i++) {
            curr = curr.next;
        }
        Node newHead = curr.next;
        curr.next = null;
        end.next = head;

        return newHead;
    }
}
