public class Solution {
    // You need to treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result left and append the last bit of n
            result = (result << 1) | (n & 1);
            
            // Unsigned right shift n to process the next bit
            n >>>= 1;
        }
        return result;
    }
}