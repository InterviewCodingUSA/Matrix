import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Initialize a 4x4 matrix with sample values
        int[][] matrix = {
                {1,5,8,7},
                {4,2,3,1},
                {9,8,4,2},
                {7,6,3,1}
        };
        // Print the minimum path sum and the path
        System.out.println(minPathSum(matrix));
    }

    // Method to calculate the minimum path sum from top-left to bottom-right
    private static int minPathSum(int[][] matrix) {
        // Get the dimensions of the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a result matrix to store minimum path sums
        int[][] result = new int[rows][cols];
        int sum = 0;

        // Initialize the first column of the result matrix
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][0];
            result[i][0] = sum;
        }

        // Initialize the first row of the result matrix
        sum = 0;
        for (int i = 0; i < cols; i++) {
            sum += matrix[0][i];
            result[0][i] = sum;
        }

        // Fill the result matrix using dynamic programming
        // For each cell, take the minimum of the path from above or left, and add the current cell's value
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = matrix[i][j] + Math.min(result[i-1][j], result[i][j-1]);
            }
        }

        // Backtrack to find the path taken
        Stack<Integer> stack = new Stack<>();
        int row = rows - 1;
        int col = cols - 1;
        stack.push(matrix[row][col]);

        // Trace back the path from bottom-right to top-left
        while (row != 0 || col != 0) {
            int val = result[row][col] - matrix[row][col];
            if (row == 0) {
                // If at the top row, move left
                col--;
            } else if (col == 0) {
                // If at the leftmost column, move up
                row--;
            } else if (val == result[row][col-1]) {
                // If the minimum came from the left, move left
                col--;
            } else if (val == result[row-1][col]) {
                // If the minimum came from above, move up
                row--;
            }
            stack.push(matrix[row][col]);
        }

        // Print the path in reverse order (from top-left to bottom-right)
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println("End");

        // Return the minimum path sum
        return result[rows-1][cols-1];
    }
}