public class Solution {
    public static int fixJ(String str, int i, int j) {
        while (str.charAt(i) != str.charAt(j)) {
            j--;
        }
        return j;
    }

    public static boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static int minCharsforPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return 0;
        }
        int i = 0, j = str.length() - 1;
        j = fixJ(str, i, j);
        while (j != i) {
            if (checkPalindrome(str, i, j)) {
                return str.length() - j - 1;
            }
            j = fixJ(str, i, --j);
        }
        return str.length() - j - 1;
    }
}
