class Solution {
    public int[] replaceElements(int[] arr) {
        int [] ans=new int[arr.length];
        int max=-1;

        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            ans[i]=max;
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return ans;
    }
}