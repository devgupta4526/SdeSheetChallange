public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int s = 0;
        int e = m;
        int mid = s + (e - s)/2;
        while(s <= e){
        double root  = Math.pow(mid, n);
            if(root == m){
                return mid;
            }
            else if(root > m){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
             mid = s + (e - s)/2;
        }
        return -1;

    }
}
