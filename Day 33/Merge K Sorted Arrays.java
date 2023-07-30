import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<k;i++){
			int l=0,e=0;
			while(l<ans.size() && e<kArrays.get(i).size()){
				if(ans.get(l)<kArrays.get(i).get(e)){
					l++;
				}
				else{
					ans.add(l,kArrays.get(i).get(e));
					e++;
				}

			}
			while(e<kArrays.get(i).size()){
				ans.add(kArrays.get(i).get(e));
				e++;
			}
		}
		return ans;
	}
}
