import java.util.*;
class PalindromePartitioningSolver {

    // partitionPalindromically -> returns all palindrome partitions of s
    public static List<List<String>> partitionPalindromically(String s) {
        int n = s.length();                                  // length of the string
        boolean[][] isPal = new boolean[n][n];               // isPal[i][j] true if s[i..j] is palindrome

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;                         // calculate end index
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) isPal[i][j] = true;       // single char or two same chars -> palindrome
                    else isPal[i][j] = isPal[i + 1][j - 1]; // depends on inner substring
                } else {
                    isPal[i][j] = false;                    // chars mismatch -> not palindrome
                }
            }
        }

        List<List<String>> result = new ArrayList<>();      // will hold all partitions
        LinkedList<String> current = new LinkedList<>();    // build current partition progressively
        backtrackPartition(0, s, isPal, current, result);   // start backtracking from index 0
        return result;                                      // return final list
    }

    // backtrackPartition -> helper to generate partitions using precomputed palindrome table
    private static void backtrackPartition(int idx, String s, boolean[][] isPal,
                                           LinkedList<String> current,
                                           List<List<String>> result) {
        if (idx == s.length()) {                            // reached end of string
            result.add(new ArrayList<>(current));           // add a copy of current partition
            return;                                         // go back to try other splits
        }
        for (int end = idx; end < s.length(); end++) {      // try every possible end index
            if (isPal[idx][end]) {                          // if substring s[idx..end] is palindrome
                current.addLast(s.substring(idx, end + 1)); // choose this substring
                backtrackPartition(end + 1, s, isPal, current, result); // recurse for rest
                current.removeLast();                       // undo choice (backtrack)
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "aab";                                  // example 1
        System.out.println("Input: " + s1 + " -> " + partitionPalindromically(s1)); // print result

        String s2 = "efe";                                  // example 2
        System.out.println("Input: " + s2 + " -> " + partitionPalindromically(s2)); // print result
    }
}

