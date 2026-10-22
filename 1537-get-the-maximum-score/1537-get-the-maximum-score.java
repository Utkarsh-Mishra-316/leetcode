class Solution {
    public int maxSum(int[] a, int[] b) {
        int i=0;
        int j=0;
        int n=a.length;
        int m= b.length;
        long sum1=0;
        long sum2=0;
        long totalmax=0;
        long mod=1_000_000_007L;
        while(i<n && j<m){
            if(a[i]<b[j]){
                sum1+=a[i];
                i++;
            }
            else if(a[i]>b[j]){
                sum2+=b[j];
                j++;
            }
            else{
                totalmax+=Math.max(sum1,sum2)+a[i];
                sum1=0;
                sum2=0;
                i++;
                j++;
            }
            
        }
        while(i<n ){
            sum1+=a[i];
            i++;

        }
        while(j<m){
            sum2+=b[j];
            j++;
        }
        totalmax+=Math.max(sum1,sum2);
        return (int) (totalmax %mod);
    }
}