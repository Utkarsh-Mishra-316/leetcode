 
class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int negCount = search(nums,0);
        int posCount = search(nums,1);
        int positive=n-posCount;
        return Math.max(negCount,positive);

        
    }
 static int search(int [] nums,int target){
    int start=0;
    int end=nums.length-1;
    int ans=nums.length;
    while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]>=target){
            ans=mid;
            end=mid-1;
           
        }
        else{
             start=mid+1;
        }
    }
    return ans;
 }
}