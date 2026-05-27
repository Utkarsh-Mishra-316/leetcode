import java.util.Arrays;

class Solution {
    public int numberOfSpecialChars(String word) {
        // Arrays ko -1 se initialize karenge taaki pata chale kaunsa char nahi aaya hai
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);
        
        // Single Pass: Saare indices track karte hain
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (Character.isLowerCase(ch)) {
                // Hum hamesha update karenge taaki LAST index mile
                lastLower[ch - 'a'] = i;
            } else {
                // Hum sirf PEHLI baar update karenge taaki FIRST index mile
                int idx = ch - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }
        
        int specialCount = 0;
        
        // Ab dono arrays ko compare karte hain
        for (int i = 0; i < 26; i++) {
            // Check: Dono exist karne chahiye, aur lastLower pehle aana chahiye firstUpper se
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}