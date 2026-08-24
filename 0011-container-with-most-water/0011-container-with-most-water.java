class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        int sum=0;
        while(left<right){
            int heights=Math.min(height[left],height[right]);
            int width=right-left;
            sum=heights*width;
            max=Math.max(max,sum);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}