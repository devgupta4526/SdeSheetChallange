import java.util.ArrayList;
import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
         // Write your code here.
          ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
          boolean visited[] = new boolean[n+1];
          boolean pathVisited[] = new boolean[n+1];

          for(int i = 0 ; i < n+1 ; i++){
            adjList.add(new ArrayList<>());
          }
          int m = edges.size();
          for(int i = 0 ; i < m ; i++){
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
          }

          for(int i = 0; i < n ;i++){
            if(visited[i] == false){
             if(dfs(adjList,i,visited,pathVisited))
               return true;
            }
          }

          return false;
          
  }

  public static boolean dfs(ArrayList<ArrayList<Integer>> adjList, int vertex,
   boolean visited[] , boolean pathVisited[]){
        visited[vertex] = true;
        pathVisited[vertex]= true;

        for(int i : adjList.get(vertex)){
          if(visited[i] == false){
            if(dfs(adjList, i, visited, pathVisited)){
              return true;
            }
          }
          else if(pathVisited[i] == true){
            return true;
          }
        }
        pathVisited[vertex] = false;
        return false;
   }
}
