//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    enum Direction { UP, DOWN, LEFT, RIGHT }
    public static void main(String[] args) {
        // Initialize a 4x4 matrix
        int[][] matrix = {
                {1, 2, 3, 4},
                {12,13,14,5},
                {11,16,15,6},
                {10, 9, 8,7}
        };
        // Call the spiral print function
        System.out.println("Iterative");
        printSpiral(matrix);
        System.out.println();
        System.out.println("Recursive");
        printSpiralRecursive(matrix);
    }

    private static void printSpiral(int[][] matrix) {
        // Define initial direction as RIGHT
        Direction dir = Direction.RIGHT;
        // Get matrix dimensions
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Track total elements to print
        int count = rows * cols;

        // Initialize boundaries
        int upLimit = 0;
        int leftLimit = 0;
        int rightLimit = cols - 1;
        int downLimit = rows - 1;
        // Initialize starting position
        int row = 0;
        int col = 0;

        // Continue until all elements are printed
        while (count > 0) {
            // Print current element
            System.out.print(matrix[row][col] + ", ");

            if (dir == Direction.RIGHT) {
                col++;
                // Check if we hit the right boundary
                if (col > rightLimit) {
                    col--; // Move back one step
                    dir = Direction.DOWN; // Change direction
                    upLimit++; // Shrink top boundary
                    row++; // Move down
                }
            } else if (dir == Direction.DOWN) {
                row++;
                // Check if we hit the bottom boundary
                if (row > downLimit) {
                    row--; // Move back one step
                    dir = Direction.LEFT; // Change direction
                    rightLimit--; // Shrink right boundary
                    col--; // Move left
                }
            } else if (dir == Direction.LEFT) {
                col--;
                // Check if we hit the left boundary
                if (col < leftLimit) {
                    col++; // Move back one step
                    dir = Direction.UP; // Change direction
                    downLimit--; // Shrink bottom boundary
                    row--; // Move up
                }
            } else { // Direction is UP
                row--;
                // Check if we hit the top boundary
                if (row < upLimit) {
                    row++; // Move back one step
                    dir = Direction.RIGHT; // Change direction
                    leftLimit++; // Shrink left boundary
                    col++; // Move right
                }
            }
            count--; // Decrement remaining elements
        }
    }

    private static void printSpiralRecursive(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        // Initialize boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Call recursive helper function
        printSpiralRecursive(matrix, top, bottom, left, right);
    }

    private static void printSpiralRecursive(int[][] matrix, int top, int bottom, int left, int right) {
        // Base case: if boundaries cross or are invalid, stop recursion
        if (top > bottom || left > right) {
            return;
        }

        // Print top row from left to right
        for (int i = left; i <= right; i++) {
            System.out.print(matrix[top][i] + ", ");
        }
        top++; // Move top boundary down

        // Print right column from top to bottom
        for (int i = top; i <= bottom; i++) {
            System.out.print(matrix[i][right] + ", ");
        }
        right--; // Move right boundary left

        // Print bottom row from right to left (if still valid)
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + ", ");
            }
            bottom--; // Move bottom boundary up
        }

        // Print left column from bottom to top (if still valid)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + ", ");
            }
            left++; // Move left boundary right
        }

        // Recurse for the inner matrix
        printSpiralRecursive(matrix, top, bottom, left, right);
    }
}