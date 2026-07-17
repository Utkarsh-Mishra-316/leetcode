class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
       int count=0;
       boolean[] arr=new boolean[baskets.length];
       for(int i=0;i<fruits.length;i++){
        for(int j=0;j<baskets.length;j++){
            if(fruits[i]<=baskets[j] && arr[j]==false){
                arr[j]=true;
                break;
            }
             
        }
       }
       for(int i=0;i<arr.length;i++){
        if(!arr[i]){
            count++;
        }
       } 
       return count;
    }
}