class Solution {
    public boolean repeatedSubstringPattern(String s) {
       String doubled=s+s;
       String subs=doubled.substring(1,doubled.length()-1);
       return subs.contains(s);
    }
}