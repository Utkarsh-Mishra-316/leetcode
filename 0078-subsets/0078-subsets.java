class Solution {
    static void subsequence(int index, List<Integer> ds,List<List<Integer>> ans,int n,int[] nums){
  if (index == n) {
    ans.add(new ArrayList<>(ds)); // 'ds' ki copy banakar add karein
    return;
}
ds.add(nums[index]);
subsequence(index+1,ds,ans,n,nums);
ds.remove(ds.size()-1);
subsequence(index+1,ds,ans,n,nums);
    }




    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = nums.length;
 subsequence(0,ds,ans,n,nums);
 return ans;
    }
}