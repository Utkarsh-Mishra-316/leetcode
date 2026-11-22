class Solution {
    public boolean checkString(String s) {
        int a=-1;
        int b=s.length();
        for(int i=0;i<s.length();i++){
            
                if(s.charAt(i)=='a'){
                    a=i;

                }
                else if(s.charAt(i)=='b' && b==s.length()){
b=i;
                }

            
             
            
           
        }
        
         return a<b;
    }
}
// class Solution {
//     public boolean checkString(String s) {

//         for(int i=0;i<s.length()-1;i++){
//             if(s.charAt(i)=='b' && s.charAt(i+1)=='a') return false;
//         }
//         return true;
//     }}