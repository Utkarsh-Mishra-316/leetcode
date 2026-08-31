class Solution {
    static void reverse(int rights,char [] s){
        int left=0;
        int right=rights;
        while(left<right){
            char ch=s[left];
            s[left]=s[right];
            s[right]=ch;
            left++;
            right--;
        }
       
    }
    public String finalString(String s) {
        char [] ch=s.toCharArray();
        int ind=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='i'){
                reverse(ind-1,ch);
            }
            else{
                ch[ind++]=c;
            }
        }
        return new String(ch,0,ind);
    }
}