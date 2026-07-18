 
class Solution {
    public int threeSumClosest(int[] nums, int target) {
Arrays.sort(nums);
int current=nums[0]+nums[1]+nums[2];
int sum=0;
for(int i=0;i<nums.length-2;i++){
int left=i+1;
int right=nums.length-1;
while(left<right){
   sum=nums[i]+nums[left]+nums[right];
   if(sum==target){
return sum;
   }
   if(Math.abs(sum-target)<Math.abs(current-target)){
    current=sum;
   }
   if(sum<target){
    left++;
   }
   else{
    right--;
   }
  
}
}
return current;
    }}













