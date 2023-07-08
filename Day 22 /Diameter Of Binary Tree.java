/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

import java.util.*;
public class Solution {
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
		int diameter[] = new int[1];
		diameter(root,diameter);
		return diameter[0];
	}

	public static int diameter(TreeNode<Integer> root , int [] diameter){
		if(root == null){
			return 0;
		}

		int lh = diameter(root.left, diameter);
		int rh = diameter(root.right, diameter);
		diameter[0] = Math.max(diameter[0], lh + rh);
		return 1 + Math.max(lh, rh);


	}
}
