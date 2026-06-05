 class Solution {
     
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
          int left=0;
          int right=n-1;
           while(left<=right){
          for(int i=0;i<n;i++){
            int temp=image[i][left]^1;
            image[i][left]=image[i][right]^1;
            image [i][right]=temp;
          }
          left++;
          right--;}
          return image;
     }
    }