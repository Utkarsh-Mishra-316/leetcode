// import java.util.*;
class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
List<List<Integer>> ans=new ArrayList<>();
if( nums==null||nums.length==0  ) return ans;
 Arrays.sort(nums);
 
 
 for(int i=0;i<nums.length;i++){
    if(i>0 && nums[i]==nums[i-1])  continue;
int left=i+1;
 int right=nums.length-1;
 while(left<right){
    int sum=nums[i]+nums[left]+nums[right];
    if(sum==0){
        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
    
    while(left<right && nums[left]==nums[left+1]) left++;
    while(left<right  && nums[right]==nums[right-1]) right--;
    left++;
    right--;
      } 
   else if(sum<0) {
        left++;
    }
    else{
        right--;
    }
 }
 }
 return ans;}}




















 

  
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
        
//         // 1. Array ko sort karna mandatory hai (O(n log n))
//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length - 2; i++) {
//             // Duplicate 'i' ko skip karo taaki unique triplets milen
//             if (i > 0 && nums[i] == nums[i - 1]) continue;

//             int left = i + 1;
//             int right = nums.length - 1;

//             while (left < right) {
//                 int sum = nums[i] + nums[left] + nums[right];

//                 if (sum == 0) {
//                     // Match mil gaya!
//                     result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
//                     // Duplicate 'left' aur 'right' ko skip karo
//                     while (left < right && nums[left] == nums[left + 1]) left++;
//                     while (left < right && nums[right] == nums[right - 1]) right--;
                    
//                     left++;
//                     right--;
//                 } else if (sum < 0) {
//                     // Sum chhota hai, toh left pointer ko bade numbers ki taraf le jao
//                     left++;
//                 } else {
//                     // Sum bada hai, toh right pointer ko chhote numbers ki taraf le jao
//                     right--;
//                 }
//             }
//         }
//         return result;
//     }
// }
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int [][][]result;
//         for(int i=0;i<nums.length;i++){
//             for(int j=1;j<nums.length;j++){
//                 for(int k=2;k<nums.length;k++){
//                       if(nums[i]+nums[j]+nums[k]==0){
//                         result=nums[i][j][k];
//                       }
//                 }
//             }
//         }
//         return result;
//     }
// }