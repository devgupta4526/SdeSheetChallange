import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, 1000000000);
        distance[src] = 0;
        
        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                
                if (distance[u] != 1000000000 && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }
        
        return distance[dest];
    }
}
