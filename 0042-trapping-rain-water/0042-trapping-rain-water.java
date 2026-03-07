// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         if (n <= 2) return 0; 

//         int left = 0;
//         int right = n - 1; // Corrected: pointing to last index
//         int sum = 0;
//         int leftMax = 0;
//         int rightMax = 0;

//         while (left < right) { // Corrected: standard two-pointer boundary
//             if (height[left] < height[right]) {
//                 // Left side choti hai, toh leftMax se compare karo
//                 if (height[left] >= leftMax) {
//                     leftMax = height[left];
//                 } else {
//                     int c = leftMax - height[left]; // Tumhara 'c' variable
//                     sum += c;
//                 }
//                 left++;
//             } else {
//                 // Right side choti ya barabar hai
//                 if (height[right] >= rightMax) {
//                     rightMax = height[right];
//                 } else {
//                     int d = rightMax - height[right]; // Tumhara 'd' variable
//                     sum += d;
//                 }
//                 right--;
//             }
//         }
//         return sum;
//     }
// }
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int []prefix=new int[n];
        int []suffix=new int[n];
        prefix[0]=height[0];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],height[i]);
        }
suffix[n-1]=height[n-1];
for(int i=n-2;i>=0;i--){
    suffix[i]=Math.max(suffix[i+1],height[i]);
}
int total=0;
for(int i=0;i<n;i++){
    total+=Math.min(prefix[i],suffix[i])-height[i];
}
return total;
    }}