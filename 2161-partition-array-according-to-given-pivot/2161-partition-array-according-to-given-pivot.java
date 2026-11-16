class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int ec=0;
        for(int num:nums){
            if(num<pivot){
                l1.add(num);
            }
            else if(num>pivot){
                l2.add(num);
            }
            else{
                ec++;
            }
        }
        int k=0;
        int [] ans=new int [nums.length];
        for(int i=0;i<l1.size();i++){
            ans[i]=l1.get(i);
            k++;
        }
        while(ec>0){
            ans[k++]=pivot;
            ec--;
        }
        for(int i=0;i<l2.size();i++){
            ans[k++]=l2.get(i);
        }
        return ans;
    }
}