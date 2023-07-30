import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
	    int row = matrix.size();
        int col = matrix.get(0).size();
        int[] flattenedMatrix = new int[row * col];
        int index = 0;

        // Flatten the 2D matrix into a 1D array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flattenedMatrix[index] = matrix.get(i).get(j);
                index++;
            }
        }

        // Sort the flattened array
        Arrays.sort(flattenedMatrix);

        // Calculate the median
        int midIndex = (row * col) / 2;
        if ((row * col) % 2 == 0) {
            // If the matrix size is even, return the average of the two middle elements
            return (flattenedMatrix[midIndex - 1] + flattenedMatrix[midIndex]) / 2;
        } else {
            // If the matrix size is odd, return the middle element
            return flattenedMatrix[midIndex];
        }	
		
		
	}
}
