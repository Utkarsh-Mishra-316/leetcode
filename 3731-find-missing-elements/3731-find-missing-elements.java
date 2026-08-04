class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int a=nums[0];
        List<Integer> ab=new ArrayList<>();
        int n=nums[nums.length-1];
         int j=0;
        for(int i=a;i<=n;i++){
            if(j<nums.length && i==nums[j]){
 j++;

            }
            else{
ab.add(i);
            }
          
        }
        if(ab.size()==0) return ab;
        return ab;
    }
}