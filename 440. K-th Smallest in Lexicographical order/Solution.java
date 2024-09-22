public class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1; // Start with the smallest lexicographical number
        k--; // Decrease k because we're starting from the first number
        
        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1); // Number of steps between curr and curr + 1
            if (steps <= k) {
                curr++; // Move to the next number
                k -= steps; // Decrease k by the steps taken
            } else {
                curr *= 10; // Move to the next level in the lexicographical tree 
                k--; // Take one step down the tree
            }
        }
        
        return curr;
    }

    // Helper function to count the steps between two numbers in the lexicographical order
    private int countSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr; // Add the number of steps in this range
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
