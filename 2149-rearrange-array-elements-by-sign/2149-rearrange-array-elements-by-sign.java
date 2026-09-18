class Solution {
    static int[] merge(ArrayList<Integer> l1,ArrayList<Integer> l2){
        int [] num=new int[l1.size()+l2.size()];
  int i=0;
  
  int k=0;
   for(  i=0;i<l1.size();i++){
   num[k]=l1.get(i);
   k++;
  
   num[k]=l2.get(i);k++; 
    }
    return num;
    }
    public int[] rearrangeArray(int[] nums) {
     int [] ans=new int[nums.length];
     ArrayList<Integer>pos=new ArrayList<>();
     ArrayList<Integer>neg=new ArrayList<>();
     for(int num:nums){
        if(num>=0){
            pos.add(num);
        }
        else{
            neg.add(num);
        }
     }   
return merge(pos,neg);
    }
}