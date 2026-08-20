class Solution {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int cnt=0;
        int ele=-1;
        int bele=-1;
        int max=0;
        for(int num:nums){
            if(num%2==0){

                if(num==ele){
                    cnt++;
                }
                else{
                    cnt=1;
                    ele=num;
                }
                if(max<cnt){
                    max=cnt;
                    bele=ele;
                }
            }
        }
        
return bele;
    }
}