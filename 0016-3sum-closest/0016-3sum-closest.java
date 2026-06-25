class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
         int current=nums[0]+nums[1]+nums[2];
        int sum=0;

      for(int i=0;i<nums.length-2;i++){

         int start=i+1;
        int end=nums.length-1;
        while(start<end){
       sum=nums[i]+nums[start]+nums[end];
       if(current==target){
        return current;
       }
       if( Math.abs(target-sum)<Math.abs(target-current)){
        current=sum;
       }  
        if(sum<target){
        start++;
       }
       else{
         end--;
         while(start<end && nums[end]==nums[end+1]) end--;
        
       }}
       }
        return current;
    
      }
     
}