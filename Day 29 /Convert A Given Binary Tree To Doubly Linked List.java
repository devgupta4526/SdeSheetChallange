import java.util.* ;
import java.io.*; 

/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


import java.util.* ;
import java.io.*; 

public class Solution {

	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        List<BinaryTreeNode<Integer>> prev = new LinkedList<BinaryTreeNode<Integer>>();
        prev.add(null);
        BTtoDLL(root, prev);
        if (prev.get(0) != null) {
            prev.get(0).left = null;
        }
        return prev.get(0);
	}

    private static void BTtoDLL(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> prev) {
        if (root != null) {
            BTtoDLL(root.right, prev);
            root.right = prev.get(0);
            if (prev.get(0) != null) {
                root.right.left = root;
            }
            prev.set(0, root);
            BTtoDLL(root.left, prev);
        }
    }

}
