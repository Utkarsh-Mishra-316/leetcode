class Solution {
    // Method name must match exactly what the platform asks for
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        
        int operations = 0;
        
        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int targetIndex = -1;
            
            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    targetIndex = i;
                }
            }
            
            if (targetIndex != -1) {
                list.set(targetIndex, minSum);
                list.remove(targetIndex + 1);
                operations++;
            }
        }
        
        return operations;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }
}