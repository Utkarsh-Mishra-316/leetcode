class Solution {
    public boolean judgeCircle(String moves) {
       int r=0;
       int l=0;
       int u=0;
       int d=0;
       for(int i=0;i<moves.length();i++){
        char ch=moves.charAt(i);
        if(ch=='L'){
            l++;
        }
        else if(ch=='R'){
            r++;
        }
        else if(ch=='U'){
            u++;
        }
        else{
        d++;
       } 
    }
    return l==r && u==d;
}}