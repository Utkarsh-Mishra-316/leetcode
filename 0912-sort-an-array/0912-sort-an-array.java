class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length);
        return nums;
    }
     
      void mergesort(int []nums,int st,int end){
        if (end - st <= 1) return;
 int mid=st+(end-st)/2;
  mergesort(nums,st,mid);
 mergesort(nums,mid,end);
 merge(nums,st,mid,end);
    }
    void merge(int []nums,int st,int mid,int end){
int []mix=new int[end-st];
int i=st;
int j=mid;
int k=0;
while(i<mid && j<end){
    if(nums[i]<nums[j]) mix[k++]=nums[i++];
    else mix[k++] = nums[j++];
}
while (i < mid) mix[k++] = nums[i++];
        while (j < end) mix[k++] = nums[j++];
        for (int l = 0; l < mix.length; l++) {
            nums[st + l] = mix[l];
        }
    }
}