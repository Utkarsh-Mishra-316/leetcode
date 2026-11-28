class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int n) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            if(max<candies[i]){
                max=candies[i];
            }
        }
 List<Boolean>ans=new ArrayList<>();        for(int i=0;i<candies.length;i++){
            if(candies[i]+n>=max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}