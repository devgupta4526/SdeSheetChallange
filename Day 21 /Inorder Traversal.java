import java.util.* ;


import java.io.*; 
/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/

public class Solution {
    public static List < Integer > getInOrderTraversal(TreeNode curr) {
    	// Write your code here.
        List<Integer> list = new ArrayList<>();
        // rec(root,list);
        // return list;
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = curr;
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
               if(st.isEmpty()) break;
               root = st.peek();
               list.add(root.data);
               st.pop();
               root = root.right;

            }
        }
        return list;

    }

    public static void rec(TreeNode root , List<Integer> list){
        if(root == null){
            return;
        }
        rec(root.left, list);
        list.add(root.data);
        rec(root.right,list);
    }
}
