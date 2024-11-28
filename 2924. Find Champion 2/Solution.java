class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];
        for (int[] e : edges) {
            indeg[e[1]]++;
        }
        
        int champion = -1;
        int zeroInDegreeCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                champion = i;
                zeroInDegreeCount++;
            }
        }
        
        return zeroInDegreeCount == 1 ? champion : -1;
    }
}
