public class Solution {
    public String shortestPalindrome(String s) {
        // Step 1: Create the reversed string
        String rev_s = new StringBuilder(s).reverse().toString();
        
        // Step 2: Concatenate s + "#" + rev_s
        String l = s + "#" + rev_s;
        
        // Step 3: Compute the LPS array using the KMP algorithm
        int[] lps = computeLPS(l);
        
        // Step 4: The number of characters to add is the part of rev_s that doesn't match
        // The length of the longest palindrome prefix is given by lps[l.length() - 1]
        // Add the non-palindrome part of the reverse string to the front of s
        return rev_s.substring(0, s.length() - lps[l.length() - 1]) + s;
    }
    
    // Helper function to compute the LPS array (used in KMP algorithm)
    private int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int j = 0;  // length of the previous longest prefix suffix
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        
        return lps;
    }
}
