class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j< n;j++){
              int temp=matrix[i][j];
              matrix[i][j]=matrix[j][i];
              matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp= matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp; 
            }
        }
 
    }
}
// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
        
//         // 1. Transpose: j must start from i
//         for(int i = 0; i < n; i++){
//             for(int j = i; j < n; j++){ 
//               int temp = matrix[i][j];
//               matrix[i][j] = matrix[j][i];
//               matrix[j][i] = temp;
//             }
//         }

//         // 2. Reverse each row: Bilkul perfect hai!
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n / 2; j++){
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[i][n - 1 - j];
//                 matrix[i][n - 1 - j] = temp; 
//             }
//         }
//     }
// }