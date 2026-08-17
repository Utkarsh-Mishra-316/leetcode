class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%3!=0) return false;
         

          int part=0;
          int total=0;
          int ans=sum/3;
          for(int i=0;i<arr.length;i++){
            total+=arr[i];
            if(total==ans) {part++;
                      total=0;
                      }          }
                      return part>=3;
    }
}