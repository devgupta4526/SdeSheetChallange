import java.util.*;

public class Solution {

    static boolean bfs(int node, int numNodes, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;

        while (!queue.isEmpty()) {
            int n = queue.remove();
            for (int i : adj.get(n)) {
                if (color[i] == -1) {
                    color[i] = 1 - color[n];
                    queue.add(i);
                } else if (color[i] == color[n]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        int numNodes = edges.size();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                if (edges.get(i).get(j) == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] color = new int[numNodes];
        for (int i = 0; i < numNodes; i++)
            color[i] = -1;

        for (int i = 0; i < numNodes; i++) {
            if (color[i] == -1) {
                if (bfs(i, numNodes, adj, color) == false)
                    return false;
            }
        }
        return true;
    }
}
