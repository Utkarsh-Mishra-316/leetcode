// class Solution {
//     public int countNegatives(int[][] grid) {
//         int count = 0;

//         for (int[] row : grid) {
//             for (int num : row) {
//                 if (num < 0) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }
class Solution {
    public int countNegatives(int[][] grid) {
        int i,j,c = 0, m=grid.length, n=grid[0].length;

        for(i=0;i<m;i++)
        {
            int low = 0, high = n-1, mid;
            while(low<=high)
            {
                mid = (low + high) / 2;
                if(grid[i][mid] < 0)
                    high = mid - 1;
                else
                    low = mid + 1;                
            }
            c = c + n - low;
        }
        return c;
    }
}