class Solution {
    public int mirrorDistance(int n) {
        int number=n;
        int sum=0;
        int rem;
        while(number>0){
            rem=number%10;
            sum=(sum*10)+rem;
            number/=10;
        }
    
    int c=Math.abs(n-sum);
    return c;
}}