class Solution {
    public int singleNumber(int[] nums) {
        int xorResult = 0;
        
        // Saare elements ka continuously XOR nikalte jao
        for (int num : nums) {
            xorResult = xorResult ^ num; // Duplicates cancel each other out!
        }
        
        return xorResult; // Sirf single number hi zinda bachega
    }
}