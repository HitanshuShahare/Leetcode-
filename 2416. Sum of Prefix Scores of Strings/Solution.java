class Solution {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    class Trie {
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++; // Increment count for every node along th word path

            }
        }
        // Get the prefix score for the given word
        public int getPrefixScore(String word){
            TrieNode node = root;
            int score = 0;
            for( char c : word.toCharArray()){
                int index = c - 'a' ;
                node = node.children[index];
                score += node.count; // add the count for this node 
            }
            return score;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words){
            trie.insert(word);
        }

        int[] result = new int[words.length];
        for(int i = 0; i< words.length; i++){
            result[i] = trie.getPrefixScore(words[i]);
        }

        return result;
    }
}