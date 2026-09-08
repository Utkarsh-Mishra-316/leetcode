class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int [] ans=new int[2];
        int [] fre=new int[n+1];
        for(int i=0;i<n;i++){
  fre[nums[i]]++;        }
  for(int i=1;i<=n;i++){
    if(fre[i]>1) ans[0]=i;
    if(fre[i]==0) ans[1]=i;
  }
  return ans;
    }
}