class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        boolean [] arr=new boolean[trainers.length];
        int i=0;
        int j=0;
        int cnt=0;
        Arrays.sort(trainers);
        Arrays.sort(players);
         while(i<players.length && j<trainers.length   ){
            if(players[i]<=trainers[j] ){
     
        i++;
        j++;
        cnt++;
    
            }
            else  {
                j++;
            }
             
        }
        return cnt;
    }
}