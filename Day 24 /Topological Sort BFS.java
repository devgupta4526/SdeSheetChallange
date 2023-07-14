import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
         ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
          for(int i = 0 ; i < v ; i++){
            adjList.add(new ArrayList<>());
          }
          for(int i = 0 ; i < e ; i++){
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
          }
        int indegree[] = new int[v];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<v ;i++)
          for(int j : adjList.get(i)){
              indegree[j]++;
          }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i<v ;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            list.add(node);
            count++;
            for(int i : adjList.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }

      return list;
    }
}
