import java.util.* ;
import java.io.*; 
/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/

public class Solution {
    public static List < Integer > getPostOrderTraversal(TreeNode curr) {
    	// Write your code here.

         ArrayList < Integer > postOrder = new ArrayList < > ();
        if (curr == null) return postOrder;

        Stack < TreeNode > s1 = new Stack < > ();
        Stack < TreeNode > s2 = new Stack < > ();
        s1.push(curr);
        while (!s1.isEmpty()) {
            curr = s1.peek();
            s1.pop();
            s2.push(curr);
            if (curr.left != null)
                s1.push(curr.left);
            if (curr.right != null)
                s1.push(curr.right);
        }
        while (!s2.isEmpty()) {
            postOrder.add(s2.peek().data);
            s2.pop();
        }
        return postOrder;
    }
}
