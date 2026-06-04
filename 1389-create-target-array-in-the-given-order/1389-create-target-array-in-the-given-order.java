// class Solution {
//     public int[] createTargetArray(int[] nums, int[] index) {
//         int[] ans = new int[nums.length];
        
//         for (int i = 0; i < nums.length; i++) {
//             int targetIdx = index[i]; // The position where we want to insert
//             int valueToInsert = nums[i]; // The value we want to place there
            
//             // 👑 THE MANUAL SHIFTING ENGINE:
//             // Shift all elements from the end of the array down to targetIdx 
//             // one position to the right to clear a spot for the new value.
//             for (int j = nums.length - 1; j > targetIdx; j--) {
//                 ans[j] = ans[j - 1];
//             }
            
//             // Now that space is cleared, insert the value safely
//             ans[targetIdx] = valueToInsert;
//         }
        
//         return ans;
//     }
// }
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            res.add(index[i],nums[i]);
        }
        int [] ans=new int[res.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }}