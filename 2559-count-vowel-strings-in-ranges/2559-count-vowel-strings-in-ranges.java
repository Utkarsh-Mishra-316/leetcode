class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pref = new int[n + 1];

        // Step 1: Prefix sum array build karein
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        // Step 2: Har query ka answer O(1) me calculate karein
        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = pref[r + 1] - pref[l];
        }

        return ans;
    }

    private boolean isVowelString(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}