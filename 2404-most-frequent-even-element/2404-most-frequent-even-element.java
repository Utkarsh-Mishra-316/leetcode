class Solution {
    public int mostFrequentEven(int[] nums) {
        int f[]=new int[100001];
        int count=0;
        int candidate=-1;
        for(int num:nums){
            if(num%2==0){
                f[num]++;
                if(f[num]>count){
                 count=f[num];
                 candidate=num;   
                }
                else if(f[num]==count && candidate>num){
                     
                     candidate=num;
                }
               
            }
            
        }
       
        return candidate;
    }
}