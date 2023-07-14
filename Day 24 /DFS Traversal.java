import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e,
     ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int vis[] = new int[v];
        for(int i = 0; i < v ; i++){
            if(vis[i] == 0){
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i,adjList,vis,temp);
                result.add(new ArrayList<>(temp));
            }
        }
        return result; 
    }

    public static void dfs(int vertex , ArrayList<ArrayList<Integer>> adjList , int[] vis , ArrayList<Integer> arr){
            vis[vertex] = 1;
            arr.add(vertex);

            for(int i : adjList.get(vertex)){
                if(vis[i] != 1){
                    dfs(i, adjList, vis, arr);
                }
            }

    }
}
