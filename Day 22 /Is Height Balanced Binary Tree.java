import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		// Write your code here.
        if(root == null){
            return true;
        }

         return rec(root) != -1;
        
	}

    public static int rec(BinaryTreeNode<Integer> root){
             if (root == null) return 0;
        
        int leftHeight = rec (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = rec (root.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1)  
              return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
