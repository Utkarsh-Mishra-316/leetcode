// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s.length()==0 || s==null){return 0;}
//         int maxlength=Integer.MIN_VALUE;
//         int left=0;
//         HashSet<Character> set=new HashSet<>();
//         for(int i=0;i<s.length();i++){
//             while(set.contains(s.charAt(i))){
// set.remove(s.charAt(left));
// left++;
//             }set.add(s.charAt(i));

//            maxlength=Math.max(maxlength,i-left+1); 
//         }
// return maxlength;

//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
    if(s.length()==0 || s==null) return 0;
    int maxl=Integer.MIN_VALUE;
        int left=0;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            maxl=Math.max(maxl,i-left+1);
        }
        return maxl;
    }}