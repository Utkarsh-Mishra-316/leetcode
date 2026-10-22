class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
       ArrayList<Integer> list=new ArrayList<>();
        
       int carry=k;
        int i=num.length-1;
       while(i>=0 || carry>0){
        if(i>=0){
            carry+=num[i];
            i--;
        }
        list.add(carry%10);
        carry=carry/10;

       } 
       Collections.reverse(list);
       return list;
    }
}