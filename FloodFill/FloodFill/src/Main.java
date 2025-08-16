import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,1,0},
                {1,0,1},
        };
        printMatrix(matrix);
        floodFill(matrix,1,1, 2 );
        System.out.println("********************");
        printMatrix(matrix);
    }
    /// Utility method to print the matrix
    private static void printMatrix(int[][] matrix) {
        // Iterate through each row of the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Convert the row to a string and print it
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // Public method to initiate the flood fill algorithm
    public static void floodFill(int[][] matrix, int row, int col, int newColor) {
        // Get the dimensions of the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a boolean array to track visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Call the recursive flood fill method with the initial color
        floodFill(matrix, row, col, newColor, matrix[row][col], visited);
    }

    // Recursive method to perform the flood fill operation
    public static void floodFill(int[][] matrix, int row, int col, int newColor, int oldColor, boolean[][] visited) {
        // Check for invalid conditions: out of bounds, different color, or already visited
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length ||
                matrix[row][col] != oldColor || visited[row][col]) {
            return; // Exit if any condition is met
        }

        // Replace the old color with the new color at the current position
        matrix[row][col] = newColor;

        // Mark the current cell as visited
        visited[row][col] = true;

        // Recursively apply flood fill to the top neighbor
        floodFill(matrix, row - 1, col, newColor, oldColor, visited);

        // Recursively apply flood fill to the bottom neighbor
        floodFill(matrix, row + 1, col, newColor, oldColor, visited);

        // Recursively apply flood fill to the left neighbor
        floodFill(matrix, row, col - 1, newColor, oldColor, visited);

        // Recursively apply flood fill to the right neighbor
        floodFill(matrix, row, col + 1, newColor, oldColor, visited);
    }
}