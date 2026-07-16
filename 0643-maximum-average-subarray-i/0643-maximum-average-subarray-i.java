class Solution {
    public double findMaxAverage(int[] nums, int k) {
         
 double sum=0;
for(int i=0;i<k;i++){
    sum+=nums[i];
}
double maxi=sum;
for(int  j=k;j<nums.length;j++){
    sum=nums[j]-nums[j-k]+sum;
    
        maxi=Math.max(sum,maxi);
     
}
return maxi/k;
    }
}