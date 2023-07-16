import java.util.*;
import java.io.*;

public class Solution {

    // Edge class representing an edge in the graph
    private static class Edge implements Comparable<Edge> {
        final int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(w, edge.w);
        }
    }

    // DisjointSet class representing the Disjoint Set data structure for union-find
    private static class DisjointSet {
        final int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
    }

    // Kruskal's algorithm to find the Minimum Spanning Tree (MST) weight
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Create a DisjointSet object to perform union-find operations
        DisjointSet set = new DisjointSet(n);
        
        // Convert the input graph to an array of Edge objects and sort it by weight in ascending order
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            List<Integer> edge = graph.get(i);
            edges[i] = new Edge(edge.get(0), edge.get(1), edge.get(2));
        }
        Arrays.sort(edges);

        int w = 0; // Initialize the weight of the MST

        // Iterate over the sorted edges and add edges to the MST until we have (n-1) edges
        for (int i = 1, j = 0; i < n; j++) {
            Edge edge = edges[j];
            int u = find(set, edge.u);
            int v = find(set, edge.v);
            if (u != v) {
                // If the vertices are not in the same set, add the edge to the MST and merge the sets
                union(set, u, v);
                w += edge.w; // Add the edge weight to the total weight of the MST
                i++;
            }
        }

        return w; // Return the weight of the MST
    }

    // Helper method to find the parent of a vertex using path compression
    private static int find(DisjointSet set, int u) {
        if (u != set.parent[u]) {
            set.parent[u] = find(set, set.parent[u]);
        }
        return set.parent[u];
    }

    // Helper method to perform union operation on two sets using rank-based optimization
    private static void union(DisjointSet set, int u, int v) {
        int pU = set.parent[u];
        int pV = set.parent[v];
        if (set.rank[pU] < set.rank[pV]) {
            set.parent[pU] = pV;
        } else if (set.rank[pU] > set.rank[pV]) {
            set.parent[pV] = pU;
        } else {
            set.parent[pV] = pU;
            set.rank[pU]++;
        }
    }
}
