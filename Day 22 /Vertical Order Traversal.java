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
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) {
    ArrayList<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;
    }

    Queue<Pair> queue = new LinkedList<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    queue.add(new Pair(root, 0));

    while (!queue.isEmpty()) {
        Pair pair = queue.remove();
        TreeNode<Integer> node = pair.node;
        int horizontalDistance = pair.h;

        // Add the node's value to the corresponding horizontal distance list in the map
        List<Integer> nodeList = map.getOrDefault(horizontalDistance, new ArrayList<>());
        nodeList.add(node.data);
        map.put(horizontalDistance, nodeList);

        if (node.left != null) {
            queue.add(new Pair(node.left, horizontalDistance - 1));
        }
        if (node.right != null) {
            queue.add(new Pair(node.right, horizontalDistance + 1));
        }
    }

    // Collect the node values in vertical order from the map
    for (List<Integer> nodeList : map.values()) {
        list.addAll(nodeList);
    }

    return list;
}


    public static class Pair{
        TreeNode<Integer> node;
        int h ;
        int level;
        Pair(TreeNode<Integer> node , int h ){
            this.node = node;
            this.h = h;
            
        }
    }
}
