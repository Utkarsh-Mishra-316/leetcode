class Solution {
    public List<Integer> intersection(int[][] nums) {
        int [] fre=new int[1001];
        int n=nums.length;
        for(int [] row: nums){
            for(int num : row){
                fre[num]++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<1001;i++){
            if(fre[i]==n){
                ans.add(i);
            }
        }
        return ans;
    }
}