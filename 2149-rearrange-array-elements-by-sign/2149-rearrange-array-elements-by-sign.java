class Solution {
    public int[] rearrangeArray(int[] nums) {
     int ans[]=new int[nums.length];
     int ni=1;
     int pi=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
           ans[2*pi]= nums[i];
           pi++;
        }
        else{
            ans[ni]=nums[i];
            ni=ni+2;
        }
    }  
return ans;
    }
}