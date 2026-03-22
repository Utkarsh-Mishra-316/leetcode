class Solution {
public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder(); 
    
    for (char c : s.toCharArray()) {
        int size = sb.length(); 
        
        if (size > 0 && sb.charAt(size - 1) == c) {
            sb.deleteCharAt(size - 1); 
        } 
        else {
            sb.append(c); 
        }
    }
    return sb.toString();
}}
// class Solution {
//     public String removeDuplicates(String s) {
//         Stack<Character> st = new Stack<>();
        
//         for (char c : s.toCharArray()) {
//              if (!st.isEmpty() && st.peek() == c) {
//                 st.pop();  
//             } else {
//                 st.push(c); 
//             }
//         }
        
        
//         StringBuilder result = new StringBuilder();
//         for (char ch : st) {
//             result.append(ch);
//         }
        
//         return result.toString();
//     }
// }