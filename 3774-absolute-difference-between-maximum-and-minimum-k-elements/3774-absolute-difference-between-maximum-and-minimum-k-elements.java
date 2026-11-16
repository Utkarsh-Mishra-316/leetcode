class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int b=0;
        int s=0;
        for(int i=0,j=nums.length-1;i<nums.length;i++,j--){
            if(k!=0){
            s+=nums[i];
            b+=nums[j];
            k--;
        }}
    return b-s;
    }

}