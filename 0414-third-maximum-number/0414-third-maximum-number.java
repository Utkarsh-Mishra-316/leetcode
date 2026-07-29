class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        int count = 0; // Distinct elements count track karne ke liye

        for (int num : nums) {
            // Duplicate skip check: agar number pehle hi top 3 me se kisi ke barabar hai
            // (aur hum unhe register kar chuke hain), toh skip kar do.
            if ((count >= 1 && num == max1) || 
                (count >= 2 && num == max2) || 
                (count >= 3 && num == max3)) {
                continue;
            }

            // Cascade Assignment Logic
            if (count == 0 || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
                count++;
            } else if (count == 1 || num > max2) {
                max3 = max2;
                max2 = num;
                count++;
            } else if (count == 2 || num > max3) {
                max3 = num;
                count++;
            }
        }

        // Agar kam se kam 3 distinct numbers mil gaye -> return max3
        // Nahi toh return overall maximum (max1)
        return count >= 3 ? (int) max3 : (int) max1;
    }
}