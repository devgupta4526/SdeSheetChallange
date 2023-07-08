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
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        //    Write your code here.
        TreeNode<Integer> node = rec(root,x,y);
        return node.data;
    }

    public static TreeNode<Integer> rec(TreeNode<Integer>root , int x , int y){
        if(root == null || root.data == x || root.data == y){
            return root;
        }

        TreeNode<Integer> left = rec(root.left, x, y);
        TreeNode<Integer> right= rec(root.right, x, y);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }
        return root;
    }
}
