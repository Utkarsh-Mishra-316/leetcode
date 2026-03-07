class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                // Left side chota hai, toh leftMax decide karega water level
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // Right side chota hai, toh rightMax decide karega
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
// class Solution {
//     public int trap(int[] height) {
//         int n=height.length;
//         int []prefix=new int[n];
//         int []suffix=new int[n];
//         prefix[0]=height[0];
//         for(int i=1;i<n;i++){
//             prefix[i]=Math.max(prefix[i-1],height[i]);
//         }
// suffix[n-1]=height[n-1];
// for(int i=n-2;i>=0;i--){
//     suffix[i]=Math.max(suffix[i+1],height[i]);
// }
// int total=0;
// for(int i=0;i<n;i++){
//     total+=Math.min(prefix[i],suffix[i])-height[i];
// }
// return total;
//     }}