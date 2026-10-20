class Solution {
    public long countBadPairs(int[] nums) {
        long n=nums.length;
        long pairs=n*(n-1)/2;
        long gp=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int diff=nums[i]-i;
            if(map.containsKey(diff)){
                gp+=map.get(diff);
            }
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return pairs-gp;
    }
}