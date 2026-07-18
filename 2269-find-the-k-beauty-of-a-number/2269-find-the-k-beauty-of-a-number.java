class Solution {
    public int divisorSubstrings(int num, int k) {
        String s=String.valueOf(num);
        int  count=0;
        for(int i=0;i<=s.length()-k;i++){
            String subv=s.substring(i,i+k);
            int val=Integer.parseInt(subv);
            if( val!=0 && num%val==0){
                count++;
            }
        }
        return count;
    }
}