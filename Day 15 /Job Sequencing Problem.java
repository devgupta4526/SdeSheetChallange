import java.util.* ;
import java.io.*; 
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        // Get the length of the jobs array
        int n = jobs.length;
        
        // Sort the jobs array in descending order based on profit
        Arrays.sort(jobs, (a, b) -> (b[1] - a[1]));
        
        // Initialize variables
        int ans = 0; // Total profit
        boolean[] res = new boolean[n]; // Track selected time slots
        
        // Iterate over the jobs array
        for (int i = 0; i < n; i++) {
            // Assign each job to an available time slot starting from the job's deadline and moving backward
            for (int j = Math.min(n - 1, jobs[i][0] - 1); j >= 0; j--) {
                // Check if the current time slot is available
                if (res[j] == false) {
                    // Select the time slot, update the profit, and mark it as used
                    res[j] = true;
                    ans += jobs[i][1];
                    break;
                }
            }
        }
        
        // Return the accumulated profit
        return ans;


        

    }
}
