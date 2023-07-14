import java.util.*;

public class Solution {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
        // Creating adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            adj.get(vec.get(i).get(0)).add(new Pair(vec.get(i).get(1), vec.get(i).get(2)));
            adj.get(vec.get(i).get(1)).add(new Pair(vec.get(i).get(0), vec.get(i).get(2)));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        int[] dist = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[source] = 0;
        pq.add(new Pair(0, source));

        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.second;
            int dis = it.first;

            if (dis > dist[node]) {
                continue;
            }

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    parent[adjNode] = node;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                path.add(Integer.MAX_VALUE);
            } else {
                path.add(dist[i]);
            }
        }

        return path;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int vertices = scanner.nextInt();
            int edges = scanner.nextInt();

            ArrayList<ArrayList<Integer>> vec = new ArrayList<>();
            for (int i = 0; i < edges; i++) {
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(scanner.nextInt());
                edge.add(scanner.nextInt());
                edge.add(scanner.nextInt());
                vec.add(edge);
            }

            int source = scanner.nextInt();

            ArrayList<Integer> result = dijkstra(vec, vertices, edges, source);

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }
}
