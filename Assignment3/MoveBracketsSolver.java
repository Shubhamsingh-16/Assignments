import java.util.*;
class MoveBracketsSolver {

    // computeMinBracketMoves -> returns minimum moves to balance brackets
    public static int computeMinBracketMoves(String s) {
        int openUnmatched = 0;   // counts unmatched '(' that we have so far
        int closeUnmatched = 0;  // counts unmatched ')' that we have so far

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openUnmatched++;                 // found an opening bracket, increase open count
            } else if (c == ')') {
                if (openUnmatched > 0) {
                    openUnmatched--;            // match this ')' with a previous '('
                } else {
                    closeUnmatched++;           // no '(' to match, this ')' is unmatched
                }
            }
        }

        // each move can fix two unmatched of same type, compute required moves
        return (openUnmatched + 1) / 2 + (closeUnmatched + 1) / 2; // combine moves for both sides
    }

    public static void main(String[] args) {
        String[] tests = {"())(", "((()", ")()(()"};            // sample inputs
        for (String t : tests) {
            System.out.println(t + " -> " + computeMinBracketMoves(t)); // print input and answer
        }
    }
}