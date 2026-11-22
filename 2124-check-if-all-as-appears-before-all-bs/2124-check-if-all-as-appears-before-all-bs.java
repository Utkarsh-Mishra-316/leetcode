// class Solution {
//     public boolean checkString(String s) {
//         int a=0;
//         int b=0;
//         for(int i=0;i<s.length();i++){
//             if(a<=b){
//                 if(s.charAt(i)=='a'){
//                     a=i;

//                 }
//                 else if(s.charAt(i)=='b'){
// b=i;
//                 }

//             }
//             if(a>b ) return false;
            
           
//         }
        
//          return true;
//     }
// }
class Solution {
    public boolean checkString(String s) {

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='b' && s.charAt(i+1)=='a') return false;
        }
        return true;
    }}