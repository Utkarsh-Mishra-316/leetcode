class Solution {
    public long gcdSum(int[] nums) {
       long maxi=Long.MIN_VALUE;
       long  [] prefixGcd=new long[nums.length];
       for(int i=0;i<nums.length;i++){
        maxi=Math.max((long)nums[i],maxi);
        prefixGcd[i]=gcd(nums[i],maxi);
        }
        Arrays.sort(prefixGcd);
        long sum=0;
        int left=0;
        int right=nums.length-1;
        while( left<right){
            sum+=gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
   long gcd(long a,long b){
   return b == 0 ? a : gcd(b, a % b);
   }
}