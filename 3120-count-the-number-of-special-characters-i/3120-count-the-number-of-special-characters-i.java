class Solution {
    public int numberOfSpecialChars(String word) {
        // Boolean arrays to track the presence of each alphabet (size 26)
        boolean[] lowerPresent = new boolean[26];
        boolean[] upperPresent = new boolean[26];
        
        // Step 1: Record the presence of characters in a single pass
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                lowerPresent[ch - 'a'] = true; // Mark lowercase presence
            } else if (ch >= 'A' && ch <= 'Z') {
                upperPresent[ch - 'A'] = true; // Mark uppercase presence
            }
        }
        
        int specialCount = 0;
        
        // Step 2: Count how many alphabets exist in both cases
        for (int i = 0; i < 26; i++) {
            if (lowerPresent[i] && upperPresent[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}