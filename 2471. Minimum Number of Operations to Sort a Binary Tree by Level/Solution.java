/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
      int ans = 0;
      Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));
      while (!q.isEmpty()) {
        List<Integer> vals = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        for (int sz = q.size(); sz > 0; --sz) {
          TreeNode node = q.poll();
          vals.add(node.val);
          if (node.left != null)
            q.offer(node.left);
          if (node.right != null)
            q.offer(node.right);
        }
        for (int i = 0; i < vals.size(); ++i)
          ids.add(i);
        Collections.sort(ids, (i, j) -> vals.get(i) - vals.get(j));
        for (int i = 0; i < ids.size(); ++i)
          for (; ids.get(i) != i; ++ans)
            swap(ids, i, ids.get(i));
      }
  
      return ans;
    }
  
    private void swap(List<Integer> ids, int i, int j) {
      final int temp = ids.get(i);
      ids.set(i, ids.get(j));
      ids.set(j, temp);
    }
  }