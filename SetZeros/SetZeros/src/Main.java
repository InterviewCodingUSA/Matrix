import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeros(matrix);
        printMatrix(matrix);
    }
    // Prints the matrix in a readable format
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int val : matrix[i]) {
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }

    // Sets entire row and column to 0 if any element in that row or column is 0
    // Time complexity: O(n^2), Space complexity: O(n)
    private static void setZeros(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Sets to store rows and columns that contain zeros
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();

        // Step 1: Identify rows and columns with zeros
        // Iterate through the matrix to find zeros
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i); // Mark row to be zeroed
                    zeroCols.add(j); // Mark column to be zeroed
                }
            }
        }

        // Step 2: Set zeros in marked rows and columns
        // Iterate through the matrix again to update elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the row or column is marked, set the element to 0
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}