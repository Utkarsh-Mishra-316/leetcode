class Solution {
    public int minBitFlips(int start, int goal) {
        int cnt=0;
        for(int i=0;i<31;i++){
            int starti=(start>>i) & 1;
            int goali=(goal>>i) & 1;
        if(starti != goali){
            cnt++;
        }
        }
        return cnt;
    }
}