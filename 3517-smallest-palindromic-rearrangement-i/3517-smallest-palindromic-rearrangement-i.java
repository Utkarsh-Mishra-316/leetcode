class Solution {
    public String smallestPalindrome(String s) {
        int frq[]=new int[26];
        for(char ch:s.toCharArray()){
            frq[ch-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        String mid="";
        for(int i=0;i<26;i++){
            char ch=(char)('a'+i);
            for(int k=0;k<frq[i]/2;k++){
             sb.append(ch);
            }
            if(frq[i]%2!=0){
                mid=String.valueOf(ch);
            }
        }
        String right=new StringBuilder(sb).reverse().toString();
        return sb.toString()+mid+right;
    }
}