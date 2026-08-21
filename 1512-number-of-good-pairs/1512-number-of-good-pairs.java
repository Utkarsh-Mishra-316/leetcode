class Solution {
    public int numIdenticalPairs(int[] nums) {
       int [] fre=new int[101];
       int pair=0;
       for(int i=0;i<nums.length;i++){
pair+=fre[nums[i]];
fre[nums[i]]++;
       } 
       return pair;
    }
}