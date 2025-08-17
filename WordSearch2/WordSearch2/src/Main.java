import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Define a 4x4 matrix of characters to search for words
        String[][] matrix = {
                {"o", "a", "a", "n"},
                {"e", "t", "a", "e"},
                {"i", "h", "k", "r"},
                {"i", "f", "l", "v"}
        };
        // Array of words to search for in the matrix
        String[] words = {"oath", "pea", "eat", "rain"};
        // Call method to find which words exist in the matrix
        ArrayList<String> matchingWords = getAllWordsInMatrix(matrix, words);

        // Print all words found in the matrix
        for (String str : matchingWords) {
            System.out.println(str);
        }
    }

    // Method to iterate through the list of words and collect those found in the matrix
    private static ArrayList<String> getAllWordsInMatrix(String[][] matrix, String[] words) {
        // Initialize an ArrayList to store words found in the matrix
        ArrayList<String> list = new ArrayList<>();
        // Loop through each word in the input array
        for (String word : words) {
            // Check if the current word exists in the matrix
            if (searchWordInMatrix(word, matrix)) {
                // If found, add the word to the result list
                list.add(word);
            }
        }
        // Return the list of found words
        return list;
    }

    // Method to search for a specific word in the matrix
    private static boolean searchWordInMatrix(String word, String[][] matrix) {
        // Get the dimensions of the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Initialize a visited array to track explored cells
        boolean[][] visited = new boolean[rows][cols];
        // Use BoxValue to track if the word is found during recursive search
        BoxValue<Boolean> box = new BoxValue<>(false);
        // Iterate through each cell in the matrix as a potential starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS from the current cell to find the word
                visitNeighbours(matrix, i, j, visited, word, 0, box);
                // If the word is found, return true immediately
                if (box.value) {
                    return true;
                }
            }
        }
        // Return whether the word was found
        return box.value;
    }

    // Recursive method to explore neighboring cells for the next character in the word
    private static void visitNeighbours(String[][] matrix, int row, int col, boolean[][] visited, String word, int index,
                                        BoxValue<Boolean> box) {
        // Get the character at the current index of the word
        String charAtIndex = Character.toString(word.charAt(index));
        // Check if the current position is invalid, already visited, or doesn't match the current character
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length ||
                !matrix[row][col].equalsIgnoreCase(charAtIndex) || visited[row][col]) {
            return;
        }
        // If the current cell matches the last character of the word, mark the word as found
        if (matrix[row][col].equalsIgnoreCase(charAtIndex) && index == word.length() - 1) {
            box.value = true;
            return;
        }
        // Mark the current cell as visited to avoid reusing it in the same path
        visited[row][col] = true;
        // Recursively explore the top neighbor
        visitNeighbours(matrix, row - 1, col, visited, word, index + 1, box);
        // Recursively explore the bottom neighbor
        visitNeighbours(matrix, row + 1, col, visited, word, index + 1, box);
        // Recursively explore the left neighbor
        visitNeighbours(matrix, row, col - 1, visited, word, index + 1, box);
        // Recursively explore the right neighbor
        visitNeighbours(matrix, row, col + 1, visited, word, index + 1, box);
        // Backtrack: unmark the current cell to allow its use in other paths
        visited[row][col] = false;
    }
}