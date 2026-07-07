class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        // Alternate characters add karo
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }

        // Agar word1 me characters bache hain
        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }

        // Agar word2 me characters bache hain
        while (j < word2.length()) {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}