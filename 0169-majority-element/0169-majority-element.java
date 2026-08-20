class Solution {
    public int majorityElement(int[] nums) {
        int a=nums.length/2;
        int cnt=0;
           
         
        for(int i=0;i<nums.length;i++){
            cnt=0;
            int ele=nums[i];
            for(int j=i;j<nums.length;j++ ){
  if(nums[i]==nums[j]){
    cnt++;
    
    if(a<cnt){
         return ele;
 
    }
  }}
  
        }
        return 0;
    }
}