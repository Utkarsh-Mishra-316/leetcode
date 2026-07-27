class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums){
            if(!set.contains(num)){
            
            set.add(num);
            nums[count]=num;
            count++;}
        }
        return count;
    }
}