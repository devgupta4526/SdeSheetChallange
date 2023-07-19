import java.util.* ;
import java.io.*; 
/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		// Write your code here.
		BinaryTreeNode<Integer> node = root;
		while(node != null){
			if(node.data == x){
				return true;
			}
			else if(node.data > x){
				node = node.left;
			}
			else{
				node = node.right;
			}
		}
		return false;
	}
}
