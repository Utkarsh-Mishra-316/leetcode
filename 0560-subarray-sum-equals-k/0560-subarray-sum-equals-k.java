import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
     HashMap<Integer,Integer> map=new HashMap<>();
     int  count=0;
     int prefixsum=0;
     map.put(0,1);
     for(int i=0;i<nums.length;i++){
        prefixsum+=nums[i];
        int remainingsum=prefixsum-k;
        if(map.containsKey(remainingsum)){
            count+=map.get(remainingsum);
        }
        map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
     }
     return count;
    }
}