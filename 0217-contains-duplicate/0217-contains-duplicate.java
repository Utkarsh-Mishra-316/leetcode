class Solution {
    public boolean containsDuplicate(int[] nums) {
      HashSet<Integer> set=new HashSet<>();
      if(nums.length<2) return false;
      for(int num: nums){
        if(set.contains(num)){
            return true;
        }
        set.add(num);
      }
      return false;
    }
}