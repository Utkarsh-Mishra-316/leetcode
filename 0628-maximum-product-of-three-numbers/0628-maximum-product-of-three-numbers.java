class Solution {
    public int maximumProduct(int[] nums) {
         int m1=Integer.MIN_VALUE;
                int m2=Integer.MIN_VALUE;
        int m3=Integer.MIN_VALUE;
        int p1=Integer.MAX_VALUE;
        
        int p=Integer.MAX_VALUE;

for(int num: nums){
    if(num>m1){
        m3=m2;
        m2=m1;
        m1=num;
        
    }
    else if( num>m2){
        m3=m2;
        m2=num;
    }
    else if(num>m3){
        m3=num;
    }
    if(num<p){
        p1=p;
        p=num;
    }
    else if(num<p1){
        p1=num;
    }
}
  long a=m1*m2*m3;
long b=m1*p*p1;

return (int) Math.max(a,b); 
    }
}