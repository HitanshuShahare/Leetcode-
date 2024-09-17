import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        // Split the sentences into words
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        // use a map to count the occurence of each word
        Map<String, Integer> wordCount = new HashMap<>();

        // Count the words in the first sentence
        for(String word : wordsA){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Count the words in the second sentence
        for(String word : wordsB){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect the uncommon words
        Set<String> uncommonWords = new HashSet<>();
        for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
            if(entry.getValue() == 1){
                uncommonWords.add(entry.getKey());
            }
        }

        // Convert set to array 
        String[] result = new String[uncommonWords.size()];
        return uncommonWords.toArray(result);
    }
}

//  Time complexity == O(n + m) where n and m are the number of words in A and B
//  Space complexity == O(n + m) due to the storage required for the map and the result set.