class Solution {
    // Similar to 2736. Maximum Sum Queries
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
      IndexedQuery[] indexedQueries = getIndexedQueries(queries);
      int[] ans = new int[queries.length];
      Arrays.fill(ans, -1);
      // Store indices (heightsIndex) of heights with heights[heightsIndex] in
      // descending order.
      List<Integer> stack = new ArrayList<>();
  
      // Iterate through queries and heights simultaneously.
      int heightsIndex = heights.length - 1;
      for (IndexedQuery indexedQuery : indexedQueries) {
        final int queryIndex = indexedQuery.queryIndex;
        final int a = indexedQuery.a;
        final int b = indexedQuery.b;
        if (a == b || heights[a] < heights[b]) {
          ans[queryIndex] = b;
        } else {
          while (heightsIndex > b) {
            while (!stack.isEmpty() && heights[stack.get(stack.size() - 1)] <= heights[heightsIndex])
              stack.remove(stack.size() - 1);
            stack.add(heightsIndex--);
          }
          final int j = lastGreater(stack, a, heights);
          if (j != -1)
            ans[queryIndex] = stack.get(j);
        }
      }
  
      return ans;
    }
  
    private record IndexedQuery(int queryIndex, int a, int b){};
  
    private int lastGreater(List<Integer> A, int target, int[] heights) {
      int l = -1;
      int r = A.size() - 1;
      while (l < r) {
        final int m = (l + r + 1) / 2;
        if (heights[A.get(m)] > heights[target])
          l = m;
        else
          r = m - 1;
      }
      return l;
    }
  
    private IndexedQuery[] getIndexedQueries(int[][] queries) {
      IndexedQuery[] indexedQueries = new IndexedQuery[queries.length];
      for (int i = 0; i < queries.length; ++i) {
        final int a = Math.min(queries[i][0], queries[i][1]);
        final int b = Math.max(queries[i][0], queries[i][1]);
        indexedQueries[i] = new IndexedQuery(i, a, b);
      }
      Arrays.sort(indexedQueries, (a, b) -> Integer.compare(b.b, a.b));
      return indexedQueries;
    }
  }