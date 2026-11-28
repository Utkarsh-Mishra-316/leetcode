class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a=0;
        int b=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<word1.length();i++){
            str.append(word1.charAt(i));a++;
            if(b<word2.length()){
                str.append(word2.charAt(i));
                b++;
            }
        }
        while(b<word2.length()){
            str.append(word2.charAt(b));
            b++;
        }
        return str.toString();
    }
}