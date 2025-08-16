//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    enum Direction {UP, DOWN, LEFT, RIGHT}

    public static void main(String[] args) {
        int[][] matrix = createSpiralMatrix(4,4);
        // Print the matrix for verification
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // O(NXM) where n = num of rows and m = num of cols
    private static int[][] createSpiralMatrix(int rows, int cols) {

        // Create a 2D array to store the spiral matrix
        int[][] matrix = new int[rows][cols];
        // Initialize starting position (row, col) for filling the matrix
        int row = 0;
        int col = 0;
        // Total number of elements to fill in the matrix
        int count = rows * cols;
        // Start moving in the RIGHT direction
        Direction dir = Direction.RIGHT;

        // Define boundaries for the spiral traversal
        int topLimit = 0;         // Topmost row not yet filled
        int bottomLimit = rows - 1; // Bottommost row not yet filled
        int leftLimit = 0;        // Leftmost column not yet filled
        int rightLimit = cols - 1; // Rightmost column not yet filled
        // Current value to be placed in the matrix, starting from 1
        int currentValue = 1;

        // Continue filling the matrix until all elements are filled
        while (count > 0) {
            // Place the current value in the matrix at position [row][col]
            matrix[row][col] = currentValue;
            // Increment the value for the next position
            currentValue++;
            // Decrease the count of remaining elements to fill
            count--;

            // Move in the current direction and check boundaries
            if (dir == Direction.RIGHT) {
                // Move right by incrementing column
                col++;
                // Check if the right boundary is reached
                if (col > rightLimit) {
                    // Revert column increment as boundary is crossed
                    col--;
                    // Move down to the next row
                    row++;
                    // Change direction to DOWN
                    dir = Direction.DOWN;
                    // Update top boundary as the top row is fully filled
                    topLimit++;
                }

            } else if (dir == Direction.LEFT) {
                // Move left by decrementing column
                col--;
                // Check if the left boundary is reached
                if (col < leftLimit) {
                    // Revert column decrement as boundary is crossed
                    col++;
                    // Move up to the previous row
                    row--;
                    // Change direction to UP
                    dir = Direction.UP;
                    // Update bottom boundary as the bottom row is fully filled
                    bottomLimit--;
                }

            } else if (dir == Direction.UP) {
                // Move up by decrementing row
                row--;
                // Check if the top boundary is reached
                if (row < topLimit) {
                    // Revert row decrement as boundary is crossed
                    row++;
                    // Move right to the next column
                    col++;
                    // Change direction to RIGHT
                    dir = Direction.RIGHT;
                    // Update left boundary as the left column is fully filled
                    leftLimit++;
                }

            } else { // Direction.DOWN
                // Move down by incrementing row
                row++;
                // Check if the bottom boundary is reached
                if (row > bottomLimit) {
                    // Revert row increment as boundary is crossed
                    row--;
                    // Move left to the previous column
                    col--;
                    // Change direction to LEFT
                    dir = Direction.LEFT;
                    // Update right boundary as the right column is fully filled
                    rightLimit--;
                }
            }
        } // End of while loop
        // Return the completed spiral matrix
        return matrix;
    }
}

