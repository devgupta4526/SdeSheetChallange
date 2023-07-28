import java.util.*;

public class Solution {
    public static int uniqueSubstrings(String input) {
        Map<Character, Integer> map = new HashMap<>();
        int n = input.length();
        int max = 0;
        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < n; right++) {
            char currentChar = input.charAt(right);
            if (map.containsKey(currentChar)) {
                // If the character is already in the map, update the left pointer
                // to skip the characters from the last occurrence of this character.
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update the character's last index in the map.
            map.put(currentChar, right);
            
            // Calculate the length of the current substring without repeating characters.
            int currentLength = right - left + 1;
            
            // Update the maximum length if necessary.
            max = Math.max(max, currentLength);
        }

        return max;
    }

 
}
