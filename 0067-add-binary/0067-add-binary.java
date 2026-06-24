class Solution {
    public String addBinary(String a, String b) {
         char[] ch=new char[Math.max(a.length(),b.length())+1];
        int i=a.length()-1;
        int j=b.length()-1;
        int sum=0;
        int carry=0;
        int c=ch.length-1;
        while(i>=0 || j>=0 || carry>0){
            sum=carry;
            if(i>=0){
                sum=sum+a.charAt(i)-'0';
                i--;
            }
             if(j>=0){
                sum=sum+b.charAt(j)-'0';
                j--;
            }
            ch[c--]=(char)((sum%2)+'0');
            carry=sum/2;
            
            }
            if(c==0){
                return new String(ch,1,ch.length-1);
        }
        return  new String(ch);
    }
}