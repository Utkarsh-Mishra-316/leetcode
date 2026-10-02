import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        // Base case: string length reaches 2 * n
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Choice 1: Add '(' if we still have available opening brackets
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); // Undo choice (Backtrack)
        }

        // Choice 2: Add ')' only if it can pair with an unmatched '('
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); // Undo choice (Backtrack)
        }
    }
}