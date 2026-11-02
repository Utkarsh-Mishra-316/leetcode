class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int med=nums[n/2];
        int cnt=0;
        for(int num: nums){
            cnt+=Math.abs(num-med);
        }return cnt;
    }
}