class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                if (currentSum == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}