import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        // Edge cases: 0, 1, 2 se strictly chhote koi primes nahi hote
        if (n <= 2) {
            return 0;
        }

        // isPrime[i] tracks whether i is prime. Size n (indices 0 to n - 1)
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // Loop runs while p * p < n
        for (int p = 2; (long) p * p < n; p++) {
            if (isPrime[p]) {
                // p ke multiples ko p * p se mark karna shuru karein
                for (int j = p * p; j < n; j += p) {
                    isPrime[j] = false; // Bug fix: j ko false karna hai, p ko nahi
                }
            }
        }

        // Count primes strictly less than n
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}