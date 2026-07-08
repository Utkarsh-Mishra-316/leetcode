// class Solution {
//     public String longestCommonPrefix(String[] strs) {
        
//     }
// }

class Solution {
    public String longestCommonPrefix(String strs[]) {
        if (strs == null || strs.length == 0) return "";

        // 1. Pehli string ko prefix maan lo
        String prefix = strs[0];

        // 2. Baaki strings ke saath compare karo
        for (int i = 1; i < strs.length; i++) {
            
            // Jab tak current string prefix se shuru nahi hoti
            while (strs[i].indexOf(prefix) != 0) {
                
                // Prefix ko piche se ek character chota karo
                prefix = prefix.substring(0, prefix.length() - 1);

                // Agar prefix khali ho gaya toh return ""
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}