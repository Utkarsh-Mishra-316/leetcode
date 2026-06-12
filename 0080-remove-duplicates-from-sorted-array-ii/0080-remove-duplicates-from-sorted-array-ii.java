class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length == 0) return 0;
        int count=1;
        int j =0;
  for(int i=1;i<nums.length;i++){
    if(nums[i]==nums[j] ){
        if( count<2){
        j++;
    nums[j]=nums[i];
    count++;
    }}
    else{
        
        j++;
        nums[j]=nums[i];
        count=1;
    }
  }
  return j+1;
    }
}