/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {

 public static boolean isSymmetric(BinaryTreeNode<Integer> root) {

        // Write your code here.

        if(root==null) return true;

        if(root.left == null && root.right == null)
          return false;

        return find(root.left,root.right);

    }

    public static boolean find(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right){

        if(left==null && right!=null) return false;

        if(left!=null && right==null) return false;

        if(left==null && right==null) return true;

        if(left.data != right.data) return false;

        return find(left.left,right.right) && find(left.right,right.left);

    }

}
