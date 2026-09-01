class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();

        while(columnNumber>0){
            columnNumber--;
            int num=columnNumber%26;
            sb.append((char)('A'+num));
            columnNumber/=26;
        }
     return  sb.reverse().toString();
    }
}