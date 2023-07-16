import java.util.* ;
import java.io.*; 
/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/

public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        // Write your code here.
     if (node == null) {
            return null;
        }

        // Map to store cloned nodes using original nodes as keys
        Map<graphNode, graphNode> clonedMap = new HashMap<>();

        // Queue for BFS traversal
        Queue<graphNode> queue = new LinkedList<>();
        queue.add(node);

        // Create the first cloned node (starting point) and add it to the map
        graphNode clonedNode = new graphNode(node.data);
        clonedMap.put(node, clonedNode);

        while (!queue.isEmpty()) {
            graphNode originalNode = queue.poll();

            // Get the cloned node corresponding to the original node
            graphNode clonedOriginalNode = clonedMap.get(originalNode);

            // Traverse the neighbours of the original node
            for (graphNode neighbour : originalNode.neighbours) {
                if (!clonedMap.containsKey(neighbour)) {
                    // If the neighbour is not yet cloned, create a new cloned node and add it to the map
                    graphNode clonedNeighbour = new graphNode(neighbour.data);
                    clonedMap.put(neighbour, clonedNeighbour);
                    queue.add(neighbour);
                }

                // Add the cloned neighbour to the cloned original node's neighbours
                clonedOriginalNode.neighbours.add(clonedMap.get(neighbour));
            }
        }

        // Return the cloned node representing the cloned graph
        return clonedNode;
        
        

    }
}
