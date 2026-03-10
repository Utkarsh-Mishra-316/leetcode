import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;

        // Next Smaller Element (NSE) aur Previous Smaller Element (PSE) ke arrays
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            // Left side mein kitne elements tak yeh min hai
            long left = i - pse[i];
            // Right side mein kitne elements tak yeh min hai
            long right = nse[i] - i;

            // Contribution calculation
            long contribution = (left * right) % mod;
            contribution = (contribution * arr[i]) % mod;

            totalSum = (totalSum + contribution) % mod;
        }

        return (int) totalSum;
    }

    // Next Smaller Element find karne ka function
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Previous Smaller or Equal Element find karne ka function
    // Note: Ek side 'equal' handle karna zaroori hai duplicate subarrays avoid karne ke liye
    private int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}