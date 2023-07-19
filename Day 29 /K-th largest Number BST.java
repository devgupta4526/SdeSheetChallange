import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;


public class Solution {

   public static int KthLargestNumber(TreeNode<Integer> root, int k) {
        ArrayList<TreeNode<Integer>> list = new ArrayList<>();
        traverse(root, list);
        int index = list.size() - k;
			if (index >= 0 && index < list.size()) {
				return list.get(index).data;
			} else {
				// Handle the case where k is out of range
				return -1; // Or you can throw an exception here if you prefer
			}
    }

    private static void traverse(TreeNode<Integer> root, ArrayList<TreeNode<Integer>> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }
}
