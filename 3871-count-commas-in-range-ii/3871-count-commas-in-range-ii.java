class Solution {
    public long countCommas(long n) {
        long ans=0;
        long boundary=1000L;
        while(n>=boundary){
            ans+=(n-boundary+1);
            if(boundary>Long.MAX_VALUE/1000){
 break;
            }
            boundary*=1000L;
        }
        
        return ans;
    }
}