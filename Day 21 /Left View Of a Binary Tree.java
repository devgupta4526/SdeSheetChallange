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
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        rec(root,list,0);
        return list;
    }

    public static void rec(TreeNode<Integer> root , ArrayList<Integer> list, int currDepth){
        if(root == null){
            return;
        }
        if(currDepth == list.size()){
            list.add(root.data);
        }

        rec(root.left, list, currDepth + 1);
        rec(root.right, list, currDepth + 1);
    }
}
