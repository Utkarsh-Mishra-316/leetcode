class Solution {
    public int hammingWeight(int n) {
        int cnt=0;
        for(int i=0;i<31;i++){
            if((n>>i)%2!=0){
                cnt++;
            }
        }
        return cnt;
    }
}