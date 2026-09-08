class Solution {
    public int countCommas(int n) {
        int sum=0;
        
        if(n>1000){
         int a=n-1000;
         return a+1;

        }
        if(n==1000) return 1;
        return 0;
    }
}