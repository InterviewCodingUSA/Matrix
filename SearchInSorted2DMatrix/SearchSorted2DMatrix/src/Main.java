//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Initialize a sample 3x4 sorted matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        // Search for target value 27 and print result
        System.out.println(search2dSorted(matrix, 34));
    }

    // Searches for a target value in a sorted 2D matrix
    // Matrix is sorted in ascending order row-wise and column-wise
    // Time complexity: O(rows + cols), Space complexity: O(1)
    private static boolean search2dSorted(int[][] matrix, int target) {
        // Get number of rows in the matrix
        int rows = matrix.length;
        // Start from the top-right corner
        int row = 0;
        int col = matrix[0].length - 1;

        // Continue searching while within matrix bounds
        while (row < rows && col >= 0) {
            // If target is found at current position, return true
            if (matrix[row][col] == target) {
                return true;
            }
            // If current element is less than target, move down (eliminate current row)
            else if (matrix[row][col] < target) {
                row++;
            }
            // If current element is greater than target, move left (eliminate current column)
            else {
                col--;
            }
        }
        // Target not found in the matrix
        return false;
    }
}