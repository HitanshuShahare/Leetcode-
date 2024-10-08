class Solution {
    public int countSegments(String s) {
        String trimmedString  = s.trim();
        if (trimmedString.isEmpty()) {
            return 0;
        }
        String[] array = trimmedString.split("\\s+");

        return array.length;
    }
}