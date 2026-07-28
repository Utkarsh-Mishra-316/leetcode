class Solution {
    public int maximumProduct(int[] nums) {
       Arrays.sort(nums);
       int n=nums.length;
       int max1=nums[n-1];
       int max2=nums[n-2];
       int max3=nums[n-3];
       int min1=nums[0];
       int min2=nums[1];
       return Math.max(max1*max2*max3,min1*min2*max1);
    }
}