class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int ascii=(int)target;
        for(int i=0;i<letters.length;i++){
            if((int)letters[i]>ascii){
                return letters[i];
            }
        }
        return letters[0];
    }
}