class Solution {
    static int searching (int nums[],int left,int right,int target){
       
        if(left<=right){
             int mid=left+(right-left)/2;
            if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            
            return searching(nums, mid+1, right,target);
        }
        else{
return searching(nums,left,mid-1,target);
        }
       
    }
    return -1;}
    public int search(int[] nums, int target) {
        return   searching( nums, 0, nums.length-1,target);
    }
}