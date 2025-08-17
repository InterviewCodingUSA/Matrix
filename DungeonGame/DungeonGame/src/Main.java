//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Initialize a 2D matrix representing the dungeon with health changes
        // Positive values increase health, negative values decrease health
        int[][] matrix = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        // Print the minimum initial health required for the prince to reach the bottom-right cell
        System.out.println(findMinHealthForPrince(matrix));
    }

    // Method to calculate the minimum initial health required for the prince to reach the bottom-right cell
    private static int findMinHealthForPrince(int[][] matrix) {
        // Get the dimensions of the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize a 2D array to store the cumulative health changes along paths
        int[][] result = new int[rows][cols];
        int sum = 0;

        // Initialize the first column: calculate cumulative health changes from top to bottom
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][0];
            result[i][0] = sum;
        }

        sum = 0;
        // Initialize the first row: calculate cumulative health changes from left to right
        for (int i = 0; i < cols; i++) {
            sum += matrix[0][i];
            result[0][i] = sum;
        }

        // Fill the result array for the rest of the grid
        // For each cell, take the maximum health from the path above or to the left, then add the current cell's health change
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = matrix[i][j] + Math.max(result[i-1][j], result[i][j-1]);
            }
        }

        // Return the minimum initial health required
        // If the final cumulative health is positive, return 0 (no additional health needed)
        // Otherwise, return the absolute value of the negative health to ensure the prince survives
        return result[rows-1][cols-1] > 0 ? 0 : result[rows-1][cols-1] * -1;
    }
}