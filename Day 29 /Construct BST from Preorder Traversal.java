import java.util.* ;
import java.io.*; 
 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		// Write your code here
		 return construct(preOrder,0,preOrder.length-1);
	}

	public static TreeNode<Integer> construct(int [] preOrder , int low , int high){
		if(low > high){
			return null;
		}
		TreeNode root = new TreeNode(preOrder[low]);
        int ind = low + 1;
        while (ind < preOrder.length && preOrder[ind] < preOrder[low]) ind++;
        root.left = construct(preOrder, low + 1, ind - 1);
        root.right = construct(preOrder, ind, high);
        return root;
	}

}
