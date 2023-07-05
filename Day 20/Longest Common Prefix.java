
public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
		 if (n == 0) {
            return "";
        }
        
        String prefix = arr[0]; // Initialize the prefix with the first string
        
        for (int i = 1; i < n; i++) {
            while (!arr[i].startsWith(prefix)) {
                // Keep removing the last character of the prefix until it becomes a prefix of the current string
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
	}

}
