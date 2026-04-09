import java.util.*;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // 1. Array ko sort karna zaroori hai Two-pointer ke liye
        Collections.sort(nums);
        
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;
        
        // 2. Two-pointer technique
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                
                count += (right - left);
                left++;
            } else {
                 right--;
            }
        }
        
        return count;
    }
}