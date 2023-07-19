import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        ArrayList<Integer> list = new ArrayList<>();
         check(root, list);
         for(int i = 0; i < list.size() - 1; i++){
             if(list.get(i) > list.get(i+1))
                return false;
         }
         return true;
    }
    public static void check(BinaryTreeNode<Integer> root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        check(root.left, list);
        list.add(root.data);
        check(root.right, list);
        
    }
}
