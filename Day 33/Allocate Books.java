import java.util.*;
import java.io.*;

public class Solution {
    // Method to find the minimum time required to study all chapters and return the result
    public static long ayushGivesNinjatest(int totalDays, int numChapters, int[] chapterTimes) {
        long totalStudyTime = 0; // Variable to store the total sum of time required for all chapters
        int maxChapterTime = Integer.MIN_VALUE; // Variable to store the maximum time required for a single chapter

        // Calculate the total sum and find the maximum time required for a single chapter
        for (int i = 0; i < numChapters; i++) {
            totalStudyTime += chapterTimes[i];
            maxChapterTime = Math.max(maxChapterTime, chapterTimes[i]);
        }

        // Initialize the lower limit of binary search 'lowerLimit' with 'maxChapterTime',
        // and the upper limit of binary search 'upperLimit' with 'totalStudyTime'.
        long lowerLimit = maxChapterTime, upperLimit = totalStudyTime, result = totalStudyTime;

        // Perform binary search to find the minimum time required
        while (lowerLimit <= upperLimit) {
            // Calculate the mid value of the current search range
            long midTime = (lowerLimit + upperLimit) / 2;

            long daysNeeded = 1; // Variable to store the number of days required to study all chapters
            long currentTime = 0; // Variable to store the current accumulated time for a day

            // Iterate through all chapters to check how many days are required to study them
            for (int i = 0; i < numChapters; i++) {
                currentTime += chapterTimes[i];
                
                // If the accumulated time for the current day exceeds the mid value (time limit for a day),
                // then start a new day and reset the accumulated time
                if (currentTime > midTime) {
                    daysNeeded++;
                    currentTime = chapterTimes[i];
                }
            }

            /*
                If the number of days required to study all the chapters is less than or equal to 'totalDays',
                it means the result is possible with the current mid value.
                So, update the 'result' with 'midTime' and compress the range to the left (upperLimit = midTime - 1).
            */
            if (daysNeeded <= totalDays) {
                result = midTime;
                upperLimit = midTime - 1;
            } else {
                // Otherwise, if we need more days than 'totalDays', then compress the range to the right (lowerLimit = midTime + 1).
                lowerLimit = midTime + 1;
            }
        }

        // Return the final result, which represents the minimum time required to study all chapters.
        return result;
    }
}
