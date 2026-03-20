import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Hum i == n par ek '0' height assume karte hain taaki stack khali ho jaye
            int currentHeight = (i == n) ? 0 : heights[i];

            // Jab tak current bar choti hai stack ke top se, rectangle calculate karo
            while (!st.isEmpty() && currentHeight < heights[st.peek()]) {
                int h = heights[st.pop()]; // Rectangle ki height jo humne pop ki
                
                int width;
                if (st.isEmpty()) {
                    width = i; // Left mein koi chota nahi mila, toh width i tak hai
                } else {
                    width = i - st.peek() - 1; // i (NSE) - st.peek (PSE) - 1
                }
                
                maxArea = Math.max(maxArea, h * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}