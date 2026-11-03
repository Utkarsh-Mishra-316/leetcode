class Solution {
    public int minMoves(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        for(int num : nums){
            if(maxi<num){
                maxi=num;
            }
        }
        int move=0;
        for(int num : nums){
            move+=(maxi-num);
        }
        return move;
    }
}