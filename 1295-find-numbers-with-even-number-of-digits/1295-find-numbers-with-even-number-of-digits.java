// class Solution {
    
//     public int findNumbers(int[] nums) {
//         int count=0;
         
//         for(int i=0;i<nums.length;i++){
//            String str = String.valueOf(nums[i]);
//            if(str.length()%2==0){
//             count++;
//            }
//     }
    
//     return count ;
//     }
// }
// class Solution {
    
//     public int findNumbers(int[] nums) {
// int count=0;
// for(int i=0;i<nums.length;i++){
//     if(evendigit(nums[i])){
//         count++;
//     }
// }
// return count;

//     }
//     public boolean evendigit(int n ){
//         int digit=0;
//         while(n>0){
//             digit++;
//             n/=10;
//         }
//          return (digit%2==0);
//     }
//     }

    class Solution {
    
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num:nums){
            int digit=(int) (Math.log10(num))+1;
        if(digit%2==0){count++;}
        }
        return count;
    }}