//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Initialize a sample 3x4 matrix
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        // Rotate the matrix 4 times (should return to original orientation)
        int[][] rotated = rotateMatrix(matrix);
//        rotated = rotateMatrix(rotated);
//        rotated = rotateMatrix(rotated);
//        rotated = rotateMatrix(rotated);

        // Print the final matrix
        printMatrix(rotated);
    }

    // Prints the matrix in a readable format
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }

    // Rotates the matrix 90 degrees clockwise
    private static int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create new matrix with swapped dimensions (cols x rows)
        int[][] result = new int[cols][rows];

        // Perform transpose and reverse rows in one step
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Place element at (i,j) to (j, rows-1-i)
                result[j][rows-1-i] = matrix[i][j];
            }
        }
        return result;
    }

    // Adding code which does transpose not used in this but just so that we know what transpose is.
    private  static int[][] transposeMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];

        for (int i = 0; i < row; i++)
        {
            int[] arr = matrix[i];
            for(int j = 0 ; j < col; j ++){
                transpose[j][i] = arr[j];
            }
        }
        return transpose;
    }
}