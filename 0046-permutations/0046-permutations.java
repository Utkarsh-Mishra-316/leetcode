class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> ans=new ArrayList<>();
         backtrack(0,nums,ans);
         return ans;
    }
    static void backtrack(int index,int[] nums, List<List<Integer>> ans){
        if(index==nums.length){
           List<Integer> curr=new ArrayList<>();
           for(int num: nums){
            curr.add(num);
           }
           ans.add(curr);
        return ;
        }
        for(int i=index;i<nums.length;i++){
        swap(index,i,nums);
        backtrack(index+1,nums,ans);
        swap(index,i,nums);}
    }
    static void swap(int index,int i,int [] nums){
        int temp=nums[index];
        nums[index]=nums[i];
        nums[i]=temp;
    }
}