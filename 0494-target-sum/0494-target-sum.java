class Solution {
    public int findTargetSumWays(int[] arr, int target) {
         return helper(0,arr,target);
    }
    int helper(int i,int [] arr,int target){
        if(i==arr.length){
            if(target==0) return 1;
            else return 0;
        }
      
        
        int add=helper(i+1,arr,target-arr[i]);
        int sub=helper(i+1,arr,target+arr[i]);
        return   add+sub; 
    }
}