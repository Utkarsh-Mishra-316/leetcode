class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int fre=entry.getValue();
            int item=entry.getKey();
      
      if(k==0){
        if(fre>=2){
            cnt++;
        }
      }
      else{
        if(map.containsKey(item+k)){
        cnt++;}
      }
        }
        return cnt;
    }
}