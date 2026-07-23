class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int leftsum=0;
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        for(int j=0;j<nums.length;j++){
            int right=total-leftsum-nums[j];
            if(leftsum==right){
                return j;
            }
            leftsum+=nums[j];
        }
return -1;
    }
}