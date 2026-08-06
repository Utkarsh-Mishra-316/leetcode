class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i=n;i<=n+10;i++){
            int num=1;
            int a=i;
            while(a>0){
                int rem=a%10;
                num*=rem;
                a=a/10;
            }
           if(num%t==0){
            return i;
           } 
        }
        return 0;
    }
}