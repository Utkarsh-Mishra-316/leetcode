class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lcount=0;
        int rcount=0;
        int ucount=0;
        for(char move:moves.toCharArray()){
            if(move=='L') lcount++;
            else if(move=='R') rcount++;
            else ucount++;
        }
        return Math.abs(lcount-rcount)+ucount;
    }
}