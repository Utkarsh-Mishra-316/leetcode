class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Sort in descending order (tallest first)
                if (heights[i] < heights[j]) {
                    // 1. Swap heights so they stay paired with names
                    int tempHeight = heights[i];
                    heights[i] = heights[j];
                    heights[j] = tempHeight;

                    // 2. Swap names
                    String st = names[i];
                    names[i] = names[j];
                    names[j] = st;
                }
            }
        }

        return names;
    }
}