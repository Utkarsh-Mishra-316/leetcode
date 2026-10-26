class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        return powwrof(n) && issqr(n) ;
    }
    boolean issqr(int n){
        long root=(long)(Math.sqrt(n));
        return (root*root==n);
    }
    boolean powwrof(int n){
        return ((n & (n-1))==0);
    }
}