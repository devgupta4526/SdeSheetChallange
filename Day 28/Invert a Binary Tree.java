import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution 
{

 private static boolean storeParents(TreeNode<Integer> root, Stack<TreeNode<Integer>> parents, TreeNode<Integer> leaf) {
        parents.push(root);

        if (root.left == null && root.right == null) {
            if (root.data.equals(leaf.data)) {
                return true;
            } else {
                parents.pop();
                return false;
            }
        }

        if (root.left != null) {
            if (storeParents(root.left, parents, leaf)) {
                return true;
            }
        }

        if (root.right != null) {
            if (storeParents(root.right, parents, leaf)) {
                return true;
            }
        }

        parents.pop();
        return false;
    }

    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        // Write your code here.
         if (root == null) {
            return null;
        }

        Stack<TreeNode<Integer>> parents = new Stack<>();
        storeParents(root, parents, leaf);

        TreeNode<Integer> head = parents.peek();
        parents.pop();

        TreeNode<Integer> par = head;
        while (!parents.isEmpty()) {
            TreeNode<Integer> p = parents.peek();
            parents.pop();

            if (p.right == head) {
                p.right = p.left;
                p.left = null;
            } else {
                p.left = null;
            }

            head.left = p;
            head = p;
        }

        return par;
    }
}
