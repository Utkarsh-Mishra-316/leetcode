import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        List<String> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        // 1. First word ke characters count kiye
        for (char ch : words[0].toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 2. Baaki words ke sath compare karke minimum frequency rakho
        for (int i = 1; i < n; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char ch : words[i].toCharArray()) {
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }

            // --- YAHAN SE AAGE KA CODE JODEIN ---
            // Har character ka minimum count map mein update karo
            for (char key : map.keySet()) {
                int countInCurrentWord = temp.getOrDefault(key, 0);
                map.put(key, Math.min(map.get(key), countInCurrentWord));
            }
        }

        // 3. Final map se list mein characters add karo
        for (char key : map.keySet()) {
            int count = map.get(key);
            while (count > 0) {
                list.add(String.valueOf(key));
                count--;
            }
        }

        return list;
    }
}