class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt=0;
        int f=0;
        Arrays.sort(arr2);
   for(int i=0;i<arr1.length;i++){
    f=0;
    for(int j=0;j<arr2.length;j++){
        int ans=Math.abs(arr1[i]-arr2[j]);
        if(ans>d){
            f++;
        }
        else{
            break;
        }
    }
    if(f==arr2.length){
        cnt++;
    }
   }
   return cnt;
    }
}