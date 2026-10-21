class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
       int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;
        
        long sum1 = 0;
        long sum2 = 0;
        long totalMax = 0;
        long MOD = 1_000_000_007L;
        
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else if (nums2[j] < nums1[i]) {
                sum2 += nums2[j];
                j++;
            } else {
                // Common element mila
                totalMax += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        
        // nums1 ke remaining elements
        while (i < n) {
            sum1 += nums1[i++];
        }
        
        // nums2 ke remaining elements
        while (j < m) {
            sum2 += nums2[j++];
        }
        
        // Aakhri section ka max add karo
        totalMax += Math.max(sum1, sum2);
        
        // Modulo lena mandatory hai LeetCode par
        return (int) (totalMax % MOD); 
    }
}