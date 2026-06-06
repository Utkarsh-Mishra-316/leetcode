// class Solution {
//     public void moveZeroes(int[] nums) {
//       int [] temp=new int[nums.length];
      
//       int tempindex = 0;
//       for(int i=0;i<nums.length;i++){
//         if(nums[i]!=0){
//             temp[tempindex]=nums[i];
//             tempindex++;
//         }
        
//       }  
//       for(int j=0;j<nums.length;j++){
//         nums[j]=temp[j];
//       }
       
//     }
   
// }
class Solution {
    public void moveZeroes(int[] nums) {
        int writer=0;
         for(int reader=0;reader<nums.length;reader++){
        if( nums[reader]!=0){
          int temp=nums[writer];
          nums[writer]=nums[reader];
          nums[reader]=temp;  
        
          writer++;}
        
     }
     
    }}