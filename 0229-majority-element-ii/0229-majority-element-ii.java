class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int cnt1=0;
        int cnt2=0;
        int candidate1=0;
        int candidate2=0;
        for(int  num: nums){
            if(cnt1==0 &&  num!=candidate2){
                cnt1++;
                candidate1=num;
            }
            else if(cnt2==0 &&  num!=candidate1){
                cnt2++;
                candidate2=num;
            }
            else if(candidate1==num) {
                cnt1++;
            }
            else if(candidate2==num){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0;
        cnt2=0;
        for(int num: nums){
            if(candidate1==num){
                cnt1++;
            }
            else if(candidate2==num){
                cnt2++;
            }
        }
        int n=nums.length/3;
        if(cnt1>n) ans.add(candidate1);
        if(cnt2>n) ans.add(candidate2);
        return ans;
    }
}