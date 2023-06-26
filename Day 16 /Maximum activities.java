import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        List<Activity> activities = new ArrayList<>();

        // Create a list of activities
        for (int i = 0; i < start.size(); i++) {
            activities.add(new Activity(start.get(i), end.get(i)));
        }

        // Sort activities based on their finish times
        Collections.sort(activities, Comparator.comparingInt(a -> a.finish));

        int count = 1;
        int endTime = activities.get(0).finish;

        // Iterate over activities and count the maximum number of activities
        for (int i = 1; i < activities.size(); i++) {
            int startTime = activities.get(i).start;

            if (startTime >= endTime) {
                count++;
                endTime = activities.get(i).finish;
            }
        }

        return count;
    }

    static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

}
