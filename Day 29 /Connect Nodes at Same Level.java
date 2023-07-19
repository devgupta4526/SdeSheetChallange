import java.util.* ;
import java.io.*; 
/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/

public class Solution {

	static class Pair{
		int level ;
		BinaryTreeNode<Integer> node;

		Pair(BinaryTreeNode<Integer> node , int level){
			this.node = node;
			this.level = level;
		}
	}
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	// Write your code here.
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()){
			Pair temp = q.remove();
			int level = temp.level;
			BinaryTreeNode<Integer> node = temp.node;
			if (!q.isEmpty() && q.peek().level == level) {
            node.next = q.peek().node;
        }
			if(node.left != null){
				q.add(new Pair(node.left, level+1));
			}
			if(node.right != null){
				q.add(new Pair(node.right, level+1));
			}
		}

	}
}
