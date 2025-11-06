
import java.util.*;

public class Phone {
     public static void main(String[] args) {
        int n = 3;
        System.out.println(generate(n)); // Output: [111, 110, 101]
    }

    // Generate all binary strings of length n where at every prefix,
    // the number of 1s is never less than the number of 0s.
    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    // Helper function using backtracking
    private static void backtrack(int n, int ones, int zeros, StringBuilder current, List<String> result) {
        if (current.length() == n) {
            if (ones > zeros) result.add(current.toString());
            return;
        }

        // Always allowed to add '1'
        current.append('1');
        backtrack(n, ones + 1, zeros, current, result);
        current.deleteCharAt(current.length() - 1);

        // Add '0' only if ones > zeros
        if (ones > zeros) {
            current.append('0');
            backtrack(n, ones, zeros + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

   
}

