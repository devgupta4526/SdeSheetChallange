import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;



public class Solution {
	public static  ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
		ArrayList<Integer> ans = new ArrayList<>();
		if (isLeaf(root) == false) ans.add(root.data);
		left(root,ans);
		leaf(root,ans);
		right(root,ans);
		return ans;
	}

	public static boolean isLeaf(TreeNode node){
		if(node.left == null &&  node.right == null){
			return true;
		}
		return false;
	}

	public static void left(TreeNode root , ArrayList<Integer> ans){
			TreeNode curr = root.left;
			while(curr != null){
				if(!isLeaf(curr)){
					ans.add(curr.data);
				}
				if(curr.left != null)
				curr = curr.left;
				else
				 curr = curr.right;
			}
	}

	public static void leaf(TreeNode root , ArrayList<Integer> ans){
		 if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if (root.left != null) leaf(root.left, ans);
        if (root.right != null) leaf(root.right, ans);
	}

	public static void right(TreeNode root , ArrayList<Integer> ans){
			TreeNode curr = root.right;
        ArrayList<Integer> rev = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                rev.add(curr.data);
            }
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        for (int i = rev.size() - 1; i >= 0; i--) {
            ans.add(rev.get(i));
        }
    
	}
}
