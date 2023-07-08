import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
		List<List<Integer>>  res = new ArrayList<>();
		List<Integer> flatList = new ArrayList<>();
         if(root == null){
             return flatList;
         }
          Queue <BinaryTreeNode<Integer>> q = new LinkedList();
         q.add(root);
         int level = 1 ; 
                while(!q.isEmpty()){
            List<Integer> l = new ArrayList();
            int c = q.size();
            for(int i=0;i<c;i++){
                BinaryTreeNode<Integer> cur = q.poll();
                l.add(cur.data);
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            if(level%2==0){
                List<Integer> ll = new ArrayList();
                for(int i =l.size()-1;i>=0;i--){
                    ll.add(l.get(i));
                }
                res.add(ll);
            }else{
                res.add(l);
            }
            level++;
        }
	 flatList = res.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return flatList;


	}
}
