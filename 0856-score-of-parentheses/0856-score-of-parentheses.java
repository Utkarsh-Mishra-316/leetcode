import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int currentScore = 0; // "count" ki jagah hum current level ka score track karenge

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Jab naya level shuru ho, purana score stack mein save kar do
                st.push(currentScore);
                currentScore = 0; // Naye level ke liye score reset
            } else {
                // Jab ')' mile, hum bahar nikal rahe hain
                int previousLevelScore = st.pop();
                
                // Rule implementation:
                // Agar currentScore 0 hai, matlab humne "()" dekha (score 1)
                // Agar currentScore > 0 hai, matlab humne "(A)" dekha (score 2 * A)
                int calculated = Math.max(2 * currentScore, 1);
                
                // Purane level ke score mein naya calculated score add kar do
                currentScore = previousLevelScore + calculated;
            }
        }
        return currentScore;
    }
}