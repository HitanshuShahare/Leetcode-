import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet<>();

        // Adding dictionary words to the Hashset for fast lookup
        for(String word : dictionary){
            dict.add(word);
        }

        // dp[i] will store the minimum extra characters needed for substring s[0...i-1]
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            // assume we add one extra character at position i
            dp[i] = dp[i - 1] +1;

            // try to match substring with dictionary words 
            for( int j = i; j >= 1; j--){
                String sub = s.substring(j - 1, i);
                if(dict.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j-1]);
                }
            }
        }
        return dp[n];
    }
}