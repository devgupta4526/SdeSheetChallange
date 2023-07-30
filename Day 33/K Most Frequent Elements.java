import java.util.*;
import java.io.*; 
public class Solution {
	public static int[] KMostFrequent(int n, int k, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int x: arr)
			map.put(x, map.getOrDefault(x, 0) + 1);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for(Integer x: map.keySet())
			pq.add(new int[]{x, map.get(x)});

		int[] ans = new int[k];
		for(int i=0; i<k; i++){
			ans[i] = pq.poll()[0];
		}

		return ans;
	}
}
