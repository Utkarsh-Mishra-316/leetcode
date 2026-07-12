
class Solution {
    public boolean isValid(String s) {
 Stack <Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
                
            }
            else{
               
                if(st.size()==0){
                    return false;
                }
                char top=st.peek();
            
                    
                    if(top=='(' && ch==')' ||top=='[' && ch==']'||top=='{' && ch=='}'){
                        st.pop();
                    }
             else{
                return false;
             }   
            }
        }
        return st.isEmpty();
    }}

// class Solution {
//     public boolean isValid(String s) {
//       Stack<Character> st = new Stack<>();
//         for(int i=0;i<s.length();i++){
//             char curr = s.charAt(i);
//             if(curr=='(' || curr=='['|| curr=='{'){
//                 st.push(curr);
//             }
//             else{
//                 if(st.size()==0){
//                     return false;
//                 }
//                 char top = st.peek();
//                  if(( top=='(' &&curr==')')||
//             ( top=='[' &&curr==']')||
//             ( top=='{' && curr=='}')){
//                 st.pop();
//             }
//             else{
//                 return false;
//             }
           
//             }
//         }
//        // Agar stack khali hai, matlab saare brackets match ho gaye
//         return st.isEmpty();
//     }
// }



