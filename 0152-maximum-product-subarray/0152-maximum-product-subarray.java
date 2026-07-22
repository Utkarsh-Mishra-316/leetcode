class Solution {
    public int maxProduct(int[] nums) {
        // int pre=1;
        // int suff=1;
        // int ans=Integer.MIN_VALUE;
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     if(pre==0) pre=1;
        //     if(suff==0) suff=1;
        //     pre=pre*nums[i];
        //     suff=suff*nums[n-i-1];
        //     ans=Math.max(ans,Math.max(suff,pre));
        // }
        // return ans;
    if(nums==null || nums.length==0) return 0; 
    
    int maxp=nums[0];
    int minp=nums[0];
    int result=nums[0];
    for(int i=1;i<nums.length;i++){
        int curr=nums[i];
        if(curr<0){
            int temp=maxp;
            maxp=minp;
            minp=temp;
        }
        maxp=Math.max(curr,maxp*curr);
        minp=Math.min(curr,minp*curr);
        result=Math.max(result,maxp);
    }
    return result;
    }
}