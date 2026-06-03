// class Solution {
//     public int[] buildArray(int[] nums) {
//         int [] ans=new int[nums.length];
//         for(int i=0;i<nums.length;i++){
// ans[i]=nums[nums[i]];
//         }
//         return ans;
//     }
// }


class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        
        // Step 1: Encode both Old Value and New Value together
        for (int i = 0; i < n; i++) {
            int oldValue = nums[i];
            
            // 🚨 TRAP ALERT: nums[i] aage ke loops me badal chuka hoga, 
            // isliye uski original purani value nikaalne ke liye % n karenge.
            int newValue = nums[nums[i]] % n; 
            
            // Encode both values into nums[i]
            nums[i] = oldValue + (newValue * n);
        }
        
        // Step 2: Decode to get only the New Values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n; // Extracting the new value
        }
        
        return nums;
    }
}










 