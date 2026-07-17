class Solution {
    public int totalFruit(int[] fruits) {
         if( fruits==null ||fruits.length==0   ) return 0;
         int maxcount=0;
         int basket1=-1;
         int basket2=-1;
         int basket1count=0;
         int basket2count=0;
         int left=0;
    for(int right=0;right<fruits.length;right++){
        int current=fruits[right];
        if(current==basket1){
            basket1count++;
        }
        else if(current==basket2){
          basket2count++;
        }
        else if(basket1==-1){
            basket1=current;
            basket1count++;
        }
        else if(basket2==-1){
            basket2=current;
            basket2count++;
        }
        else{
        while(basket1count>0 && basket2count>0){
           int lf=fruits[left];
           if(lf==basket1){
            basket1count--;
           }
           else if(lf==basket2){
            basket2count--;
           }
           left++;
        }
        if(basket1count==0){
            basket1=current;
            basket1count=1;
        }
        else if(basket2count==0){
            basket2=current;
            basket2count=1;
        }

        
       
    }
    maxcount=Math.max(maxcount,right-left+1);
}
 return maxcount;
}}