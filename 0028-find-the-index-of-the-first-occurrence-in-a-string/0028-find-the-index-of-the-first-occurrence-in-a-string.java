class Solution {
    public int strStr(String haystack, String needle) {
         
         int c=haystack.indexOf(needle);
         if(c>=0){
            return c;
         }
        
        return -1;
    }
}