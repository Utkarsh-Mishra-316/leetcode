class Solution {
    public String reverseWords(String s) {
        // 1. String ko space ke basis par words array mein split karein
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        
        // 2. Har word ko reverse karein aur result mein append karein
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            result.append(sb.reverse());
            
            // Last word ke baad space nahi lagana hai
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}