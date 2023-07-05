public class Solution {	
	public static String longestPalinSubstring(String str) {
		// Write your code here.
		// String ans = "";
		// int max = Integer.MIN_VALUE;
		// int n = str.length();
		// for(int i = 0 ; i < n ; i++){
		//   for(int j = i ; j <=n ; j++){
		// 	String s = str.substring(i,j);
		// 	boolean check = check(s);
		// 	if(check && max < s.length()){
		// 		ans = s;
		// 		max = s.length();
		// 	}
		//   }
			
		// }
		// return ans;

		 String longest = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            String odd = check(str, i, i);
            if (odd.length() > longest.length()) {
                longest = odd;
            }
        }
        for (int i = 0; i < n; i++) {
            String even = check(str, i, i + 1);
            if (even.length() > longest.length()) {
                longest = even;
            }
        }
        return longest;
	}

	public static String check(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

	public static boolean check(String s){
		int start = 0;
		int end = s.length()-1;
		while(start < end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
