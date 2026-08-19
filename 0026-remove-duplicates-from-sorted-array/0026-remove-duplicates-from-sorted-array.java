class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int cnt=1;
        
          for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[cnt-1]){
  nums[cnt]=nums[i];
  cnt++;
            }
        }
        return cnt;
    }
}