import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
		List<List<Integer>> list = new ArrayList<>();
		 list.add(new ArrayList<>()); // Initialize list at index 0
         list.add(new ArrayList<>()); // Initialize list at index 1
         list.add(new ArrayList<>()); // Initialize list at index 2
		rec(root,list);
		return list;
    }

	public static void rec(BinaryTreeNode<Integer> root , List<List<Integer>> list){
		if(root == null){
			return;
		}
		list.get(1).add(root.data);
		rec(root.left, list);
		list.get(0).add(root.data);
		rec(root.right, list);
		list.get(2).add(root.data);
	}
}
