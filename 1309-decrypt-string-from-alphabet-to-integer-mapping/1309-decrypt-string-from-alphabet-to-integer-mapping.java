class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb=new StringBuilder();
 int i=s.length()-1;
  while(i>=0){
    if(s.charAt(i)=='#'){
        int num=Integer.parseInt(s.substring(i-2,i));
        sb.append((char)('a'+num-1));
        i-=3;
    }
    else{
        int num=s.charAt(i)-'0';
        sb.append((char)('a'+num-1));
        i--;
    }
  }      
  return sb.reverse().toString();
    }
}