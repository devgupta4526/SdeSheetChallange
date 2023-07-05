public class Solution {

	public static int zAlgorithm(String text, String pattern, int n, int m) {
		// Write your code here
		int count = 0;
        for (int i = 0; i <= n - m; i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                int startText = i;
                int startPattern = 0;
                int endPattern = m - 1;
                while (startPattern <= endPattern) {
                    if (text.charAt(startText) != pattern.charAt(startPattern)) {
                        break;
                    }
                    startPattern++;
                    startText++;
                }
                if (startPattern > endPattern) {
                    count++;
                }
            }
        }
        return count;

	}

}
