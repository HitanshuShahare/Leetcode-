class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int i = 0;
        
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            
            while (i < n && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
            comp.append(count).append(c);
        }
        return comp.toString();
    }
}