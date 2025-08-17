//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Initialize a 2D matrix representing a map where '1' is land and '0' is water
        String[][] matrix = {
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };

        // Print the number of islands found in the matrix
        System.out.println(getNumOfIslands(matrix));
    }

    // Method to count the number of islands in the matrix
    // An island is a group of connected '1's (land) surrounded by '0's (water)
    private static int getNumOfIslands(String[][] matrix) {
        // Get the dimensions of the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Create a boolean array to track visited cells
        boolean[][] visited = new boolean[rows][cols];
        // Initialize counter for number of islands
        int count = 0;

        // Iterate through each cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell contains '1' (land) and hasn't been visited
                if (matrix[i][j].equalsIgnoreCase("1") && visited[i][j] == false) {
                    // Increment island counter
                    count++;
                    // Visit all connected land cells using DFS
                    visitNeighbours(matrix, i, j, visited);
                }
            }
        }

        // Return the total number of islands found
        return count;
    }

    // Helper method to perform Depth-First Search (DFS) to mark all connected land cells
    private static void visitNeighbours(String[][] matrix, int row, int col, boolean[][] visited) {
        // Check if the current cell is out of bounds, is water ('0'), or has been visited
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length ||
                matrix[row][col].equalsIgnoreCase("0") || visited[row][col] == true) {
            // If any condition is true, stop exploring this path
            return;
        }
        // Mark the current cell as visited
        visited[row][col] = true;
        // Recursively explore all four adjacent cells (top, bottom, left, right)
        visitNeighbours(matrix, row - 1, col, visited); // top neighbour
        visitNeighbours(matrix, row + 1, col, visited); // bottom neighbour
        visitNeighbours(matrix, row, col - 1, visited); // left neighbour
        visitNeighbours(matrix, row, col + 1, visited); // right neighbour
    }
}