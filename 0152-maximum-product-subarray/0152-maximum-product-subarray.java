class Solution {
    public int maxProduct(int[] nums) {
       
        int max= nums[0];
        int currmax=nums[0];
int currmin=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            if(curr<0){
                int temp=currmax;
                currmax=currmin;
                currmin=temp;
            }
            currmax=Math.max(curr,curr*currmax);
            currmin=Math.min(curr,curr*currmin);
            max=Math.max(max,currmax);
        }
        return max;
    }
}