import java.util.* ;
import java.io.*; 
public class Solution {
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){
		// WRITE YOUR CODE HERE
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		 ArrayList<Integer> list = new ArrayList<>();
		 int n = edges.length;
		for(int i = 0 ; i < n ; i++){
			adjList.get(edges[i][1]).add(edges[i][0]);
			adjList.get(edges[i][0]).add(edges[i][1]);
		}
		Queue<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[vertex];
		q.add(0);
		vis[0] = true;
		while(!q.isEmpty()){
			int node  = q.remove();
			list.add(node);
			for(int i : adjList.get(node)){
				if(vis[i] == false){
					vis[i] = true;
					q.add(i);
				}
			}
		}
		return list;
	}
}

