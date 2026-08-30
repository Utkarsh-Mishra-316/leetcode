class Solution {
    public int minSwapsCouples(int[] row) {
       int cnt=0;
       for(int i=0;i<row.length;i+=2){
        int patner=row[i]^1;
        int j=i+1;
        while(row[j]!=patner){
            j++;
        }
        if(j==i+1){
            continue;
        }
        int temp=row[i+1];
        row[i+1]=row[j];
        row[j]=temp;
        cnt++;
       } 
       return cnt;
    }
}