import java.util.*;

public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }

        List<Integer> finishingTimes = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, finishingTimes);
            }
        }

        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph.get(i)) {
                transpose.get(neighbor).add(i);
            }
        }

        List<List<Integer>> components = new ArrayList<>();
        Arrays.fill(visited, false);

        for (int i = n - 1; i >= 0; i--) {
            int node = finishingTimes.get(i);
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs(transpose, node, visited, component);
                components.add(component);
            }
        }

        return components;
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> result) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, result);
            }
        }

        result.add(node);
    }
}
