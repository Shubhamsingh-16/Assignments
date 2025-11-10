package Assignment4;
public class CountNQueenArrangements {

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Total ways to place " + n + " queens: " + totalQueenWays(n));
    }

    // Main function to start recursion
    public static int totalQueenWays(int n) {
        boolean[] cols = new boolean[n];       // Track used columns
        boolean[] diag1 = new boolean[2 * n];  // Track major diagonals (r + c)
        boolean[] diag2 = new boolean[2 * n];  // Track minor diagonals (r - c + n)
        return placeQueen(0, n, cols, diag1, diag2);
    }

    // Recursive helper: tries to place queens row by row
    private static int placeQueen(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) return 1; // Reached end → found valid board
        int count = 0;

        for (int col = 0; col < n; col++) {
            // If column or diagonals are blocked, skip
            if (cols[col] || diag1[row + col] || diag2[row - col + n]) continue;

            // Choose this position
            cols[col] = diag1[row + col] = diag2[row - col + n] = true;

            // Recurse for next row
            count += placeQueen(row + 1, n, cols, diag1, diag2);

            // Backtrack (undo the choice)
            cols[col] = diag1[row + col] = diag2[row - col + n] = false;
        }

        return count;
    }
}