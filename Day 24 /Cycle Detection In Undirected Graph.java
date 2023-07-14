import java.util.ArrayList;
import java.util.Queue;
import java.util.*;

public class Solution {
    
    static class Pair{
        int node;
        int parent;
        Pair(int node , int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        boolean visited[] = new boolean[n +1];
        
        for(int i = 0; i < n + 1 ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i = 0 ; i < n +1 ;i++){
            if(visited[i] == false)
            if(detect(adjList, i, visited)== "Yes"){
                return "Yes";
            }
        }

        return "No";
       

    }

    public static String detect(ArrayList<ArrayList<Integer>> adjList, int vertex , 
    boolean visited[]){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(vertex,-1));
        visited[vertex] = true;
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int node = p.node;
            int parent = p.parent;
            for(int i : adjList.get(node)){
                if(visited[i] != true){
                    queue.add(new Pair(i, node));
                    visited[i] = true;
                }
                else if(parent != i){
                    return "Yes";
                }
            }
        }
        return "No";
    }
    
}
