class Solution {
    public int findUnsortedSubarray(int[] nums) {
 int start=-1;
 int max=nums[0];
 for(int i=1;i<nums.length;i++){
    if(max>nums[i]){
        start=i;
 
    }
    else{
        max=nums[i];
    }
 }
 int end=0;
 int min=nums[nums.length-1];
 for(int i=nums.length-2;i>=0;i--){
    if(min<nums[i]){
        end=i;
    }
    else{
        min=nums[i];
    }
 } return start-end+1;
    }
}