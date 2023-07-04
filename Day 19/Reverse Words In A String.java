public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		// String[] s = str.split(" ");
		// String ss = "";
		// for(int i=s.length-1;i>=0;i--){
		// 	ss+=s[i].trim()+" ";
		// }
		// return ss;

		str.trim();
    String[] s = str.split(" ");
    StringBuilder s1 = new StringBuilder("");
    for (int i = s.length - 1; i >= 0; i--) {
        if (i == 0) {
            s1.append(s[i]);
        } else {
            s1.append(s[i] + " ");
        }
    }
    return s1.toString();
	}
}
