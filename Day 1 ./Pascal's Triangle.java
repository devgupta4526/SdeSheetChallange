import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
		  ArrayList<ArrayList<Long>> ans = new ArrayList<>();

		  for(int i = 0 ; i < n ; i++){
			  ArrayList<Long> temp = new ArrayList<>();
			  for(int j = 0 ; j <= i ; j++){
				  if(j==0 || j ==i){
					  temp.add(1L);
				  }
				  else{
					  long a = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
					  temp.add(a);
				  }
			  }
			  ans.add(temp);
		  }

	return ans;
	}
}
