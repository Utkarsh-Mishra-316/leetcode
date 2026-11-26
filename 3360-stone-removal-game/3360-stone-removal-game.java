class Solution {
    public boolean canAliceWin(int n) {
        int c = 10;               // Stones to remove on current turn
        boolean aliceTurn = true; // Alice always starts

        while (n >= c) {
            n = n - c;            // Subtract c stones (NOT %)
            c--;                  // Next turn requires 1 fewer stone
            aliceTurn = !aliceTurn; // Switch turn between Alice and Bob
        }

        // Whoever's turn it is when n < c CANNOT move, so they lose!
        // If it is Bob's turn (!aliceTurn), Bob loses -> Alice wins (true).
        return !aliceTurn;
    }
}