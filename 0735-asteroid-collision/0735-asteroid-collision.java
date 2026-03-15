
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> st = new ArrayList<>(); // Using list like a stack for easy conversion

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                // If it's a positive asteroid, it moves Right. Just add it.
                st.add(asteroids[i]);
            } else {
                // If it's a negative asteroid, it moves Left. Check for collisions.
                // Collide while stack top is Positive and smaller than current asteroid
                while (!st.isEmpty() && st.get(st.size() - 1) > 0 && st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }

                // If they are of equal size, both get destroyed
                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                } 
                // If stack is empty or top is negative (moving away), add current
                else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(asteroids[i]);
                }
            }
        }

        // Convert List back to int array
        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
        return result;
    }
}