class Solution {
    public int bitwiseComplement(int n) {
        // Edge case: if n is 0, binary is "0", complement is "1"
        if (n == 0) return 1;
        
        int mask = 0;
        int temp = n;
        
        // Build a mask of 1s with the same length as n
        // Example: n = 5 (101), mask will become 7 (111)
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        
        // XOR flips the bits where the mask has 1s
        return n ^ mask;
    }
}