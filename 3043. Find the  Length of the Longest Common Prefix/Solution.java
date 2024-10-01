class TrieNode {
    TrieNode[] children = new TrieNode[10]; // Digits from 0 to 9
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        
        // Insert all numbers from arr1 into the Trie
        for (int num : arr1) {
            insert(root, String.valueOf(num));
        }

        int maxLength = 0;

        // For each number in arr2, find the longest common prefix with the Trie
        for (int num : arr2) {
            maxLength = Math.max(maxLength, findLongestCommonPrefix(root, String.valueOf(num)));
        }

        return maxLength;
    }

    private void insert(TrieNode root, String numStr) {
        TrieNode node = root;
        for (char c : numStr.toCharArray()) {
            int index = c - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
    }

    private int findLongestCommonPrefix(TrieNode root, String numStr) {
        TrieNode node =  root;
        int commonLength = 0;

        for (char c : numStr.toCharArray()) {
            int index = c - '0';
            if (node.children[index] == null) {
                break; // No more common prefix
            }
            node = node.children[index];
            commonLength++;
        }

        return commonLength;
    }
}
