//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Define a constant for representing obstacles (infinite value)
    static final int inf = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Initialize a 2D matrix representing the grid with obstacles (inf) and free paths (0)
        int[][] matrix = {
                {0,0,inf,0},
                {0,0,0,0},
                {inf,inf,0,0},
                {0,0,0,0},
        };
        // Print the number of unique paths from top-left to bottom-right
        System.out.println(getNumberUniquePathsWithObstacles(matrix));
    }

    // Method to calculate the number of unique paths in a grid with obstacles
    public static int getNumberUniquePathsWithObstacles(int[][] matrix) {
        // Get the dimensions of the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Initialize a 2D array to store the number of unique paths to each cell
        int[][] result = new int[rows][cols];

        // If the starting cell has an obstacle, no paths are possible
        if (matrix[0][0] == inf) {
            return 0;
        }
        // Initialize the starting cell with 1 path
        result[0][0] = 1;

        // Initialize the first column: if a cell has an obstacle or the previous cell is unreachable, mark as inf; otherwise, 1
        for (int i = 1; i < rows; i++) {
            result[i][0] = (matrix[i][0] == inf) || (matrix[i-1][0] == inf) ? inf : 1;
        }
        // Initialize the first row: if a cell has an obstacle or the previous cell is unreachable, mark as inf; otherwise, 1
        for (int i = 1; i < cols; i++) {
            result[0][i] = (matrix[0][i] == inf) || (matrix[0][i-1] == inf) ? inf : 1;
        }

        // Fill the result array for the rest of the grid
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // If the current cell has an obstacle, mark it as unreachable (inf)
                if (matrix[i][j] == inf) {
                    result[i][j] = inf;
                }
                // If both the cell above and the cell to the left are unreachable, this cell is also unreachable
                else if (result[i-1][j] == inf && result[i][j-1] == inf) {
                    result[i][j] = inf;
                }
                // If both the cell above and the cell to the left are reachable, sum the number of paths
                else if (result[i-1][j] != inf && result[i][j-1] != inf) {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
                // If only one of the cell above or the cell to the left is reachable, take the minimum (effectively the non-inf value)
                else {
                    result[i][j] = Math.min(result[i-1][j], result[i][j-1]);
                }
            }
        }

        // Return the number of unique paths to the bottom-right cell
        return result[rows-1][cols-1];
    }
}