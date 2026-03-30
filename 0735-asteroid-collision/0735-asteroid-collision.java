import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

             while (!st.isEmpty() && st.peek() > 0 && ast < 0) {
                
                 if (Math.abs(st.peek()) < Math.abs(ast)) {
                    st.pop();
                    continue;  
                } 
                 else if (Math.abs(st.peek()) == Math.abs(ast)) {
                    st.pop();
                    destroyed = true;
                    break;
                } 
                 else {
                    destroyed = true;
                    break;
                }
            }

             if (!destroyed) {
                st.push(ast);
            }
        }

        // Convert stack back to array
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}