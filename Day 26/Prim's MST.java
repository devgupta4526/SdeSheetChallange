import java.util.*;

public class Solution {

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        List<List<int[]>> adj = new ArrayList<List<int[]>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : g) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            adj.get(u).add(new int[] { v, weight });
            adj.get(v).add(new int[] { u, weight });
        }

        int[] weight = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean[] inMst = new boolean[n + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[1] = 0;

        // int[2] - (node, weight)
        Queue<int[]> queue = new PriorityQueue<>((s1, s2) -> Integer.compare(s1[1], s2[1]));
        queue.offer(new int[] { 1, 0 });

        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] uw = queue.poll();
            while (inMst[uw[0]]) {
                uw = queue.poll();
            }
            inMst[uw[0]] = true;

            if (i > 0) {
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(uw[0]);
                edge.add(parent[uw[0]]);
                edge.add(weight[uw[0]]);
                mst.add(edge);
            }

            for (int[] vw : adj.get(uw[0])) {
                int v = vw[0];
                int weightUtoV = vw[1];
                if (!inMst[v] && weight[v] > weightUtoV) {
                    parent[v] = uw[0];
                    weight[v] = weightUtoV;
                    queue.offer(new int[] { v, weightUtoV });
                }
            }
        }

        return mst;
    }
}
