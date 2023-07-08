import java.util.* ;
import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        rec(root,list,x);
        return list;
    }

    public static void rec(TreeNode root, ArrayList<Integer> list , int key){
        if(root == null){
            return;
        }
        list.add(root.data);
         if(key == root.data){
            return;
        }
        
        rec(root.left, list, key);
        rec(root.right, list,key);
        if(list.get(list.size()-1) != key){
         list.remove(list.size()-1);
        }  
    }
}
