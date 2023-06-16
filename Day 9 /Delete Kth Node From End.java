/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.
        Node fast = head;
        Node slow = head;
        for(int i = 0 ; i < K ; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        Node temp = slow.prev;
        if(temp == null){
            return head.next;
        }
        else {
            temp.next = slow.next;
        }
        
        return head;
    }
}
