class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String res []=new String[score.length];
        int [][] pair=new int[n][2];
           for(int i=0;i<score.length;i++){
            pair[i][0]=score[i];
            pair[i][1]=i;
           }
Arrays.sort(pair, (a, b) -> b[0] - a[0]);
          for(int i=0;i<score.length;i++){
            int originalIndex=pair[i][1];
            if (i == 0) {
                res[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                res[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                res[originalIndex] = "Bronze Medal";
            } else {
                res[originalIndex] = String.valueOf(i + 1);
            }
        
          }
          return res;
    }
}