class Solution {
     
    public static void reverse(char []ch,int ind){
        int left=0;
        int right= ind;
        while(left<right){
        char temp=ch[left];
        ch[left]=ch[right];
        ch[right]=temp;
        left++;
        right--;}
    }
    public String finalString(String s) {
        char [] ch=s.toCharArray();
 
 int ind=0;
         for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
            if(c =='i'){
                reverse(ch,ind-1);
            }
            else{
                ch[ind++]=c;
            }
        }
       return new String(ch,0,ind);
}
 
    }