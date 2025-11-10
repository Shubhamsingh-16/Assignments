

public class SudokuHumanSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);
        printBoard(board);
    }

    // Entry point
    public static void solveSudoku(char[][] board) {
        solveCell(board);
    }

    // Recursive helper
    private static boolean solveCell(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Find empty cell
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {

                        // Check if safe to place
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            // Move to next cell
                            if (solveCell(board)) return true;

                            // Undo (backtrack)
                            board[row][col] = '.';
                        }
                    }
                    // No valid number worked → dead end
                    return false;
                }
            }
        }
        return true; // All cells filled
    }

    // Check if placing num is valid
    private static boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false; // Row
            if (board[i][col] == num) return false; // Column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false; // 3x3 Box
        }
        return true;
    }

    // Print solved Sudoku
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }
}
