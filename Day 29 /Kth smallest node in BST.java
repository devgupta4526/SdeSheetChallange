import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/


public class Solution 
{

	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
		//  Write your code here.
		ArrayList<TreeNode<Integer>> list = new ArrayList<>();
        traverse(root, list);
        return list.get(k-1).data;

	}

	 private static void traverse(TreeNode<Integer> root, ArrayList<TreeNode<Integer>> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }


}
