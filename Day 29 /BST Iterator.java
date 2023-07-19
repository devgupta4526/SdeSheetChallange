import java.util.* ;
import java.io.*; 
/*
    Definition of Node class for reference

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

*/
public class Solution {

    static class BSTIterator{
        ArrayList<Integer> list ;
        int i;
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
            list = new ArrayList<>();
            i =0;
            inorder(root);
        }

        public void inorder(TreeNode<Integer> node){
            if(node == null){
                return;
            }
            inorder(node.left);
            list.add(node.data);
            inorder(node.right);
        }

        int next(){
            // Write your code here
            return list.get(i++);
            
        }

        boolean hasNext(){
            // Write your code here
            if(i<list.size()){
                return true;
            }
            return false;
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
