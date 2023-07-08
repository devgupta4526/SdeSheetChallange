import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/

public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
		Queue<Pair> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new TreeMap<>();
		if(root == null) return list;
		q.add(new Pair(root,0));
		while(!q.isEmpty()){
			Pair temp = q.remove();
			if(!map.containsKey(temp.h)){
				map.put(temp.h, temp.node.val);
			}
			if(temp.node.left != null){
				q.add(new Pair(temp.node.left, temp.h -1));
			}
			if(temp.node.right != null){
				q.add(new Pair(temp.node.right, temp.h +1));
			}
		}

		 for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            list.add(entry.getValue()); 
        }
		return list;
		
		

	}

	public static class Pair{
		BinaryTreeNode node;
		int h;
		Pair(BinaryTreeNode node , int h){
			this.h = h;
			this.node = node;
		}

	}
}
