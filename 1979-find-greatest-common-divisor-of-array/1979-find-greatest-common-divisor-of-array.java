class Solution {
    static int gcd(int a,int b){
        while(a!=b){
        if(a>b){
            a=a-b;
        }
        else{
            b=b-a;
        }
       
    }
     return a;}
    public int findGCD(int[] nums) {
       int max = nums[0];
        int min = nums[0];

for (int i = 1; i < nums.length; i++) {
    if (nums[i] > max) max = nums[i];
    if (nums[i] < min) min = nums[i];
} 
if(min==max) return min;

   return  gcd(min,max); }
}