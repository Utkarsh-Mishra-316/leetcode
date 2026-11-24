class Solution {
    long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    long lcm(long a ,long b){
        return (a/gcd(a,b))*b;
    }
    public int maxLength(int[] nums) {
        long p=1;
        int maxl=0;
        for(int i=0;i<nums.length;i++){
            p=1;
            long g=nums[i];
            long l=nums[i];
            for(int j=i;j<nums.length;j++){
                p*=nums[j];
                g=gcd(g,nums[j]);
                l=lcm(l,nums[j]);
if(p==g*l){
    maxl=Math.max(maxl,j-i+1);
}
if (p > 25200) break;
            }
        }
return maxl;
    }
}