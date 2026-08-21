class Solution {
    public int maxSubArray(int[] nums) {
        int cs=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            cs+=num;
            max=Math.max(max,cs);
            if(cs<0){
                cs=0;
            }
        }
        return max;
    }
}