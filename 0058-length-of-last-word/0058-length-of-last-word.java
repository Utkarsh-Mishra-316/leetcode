class Solution {
    public int lengthOfLastWord(String s) {
        //   s = s.trim();
        int c=s.length();
      
        int count=0;
        for(int i=c-1;i>=0;i--){

         if(s.charAt(i) == ' '&& count!=0){
                break;
            
            }
            if(s.charAt(i) != ' ')
            count++;
        }
        return count;
    }
}