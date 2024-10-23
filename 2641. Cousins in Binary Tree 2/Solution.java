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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Map<Integer, Integer> levelSum = new HashMap<>();
        Map<TreeNode, Integer> nodeLevel = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        nodeLevel.put(root, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int level = nodeLevel.get(queue.peek());
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                    nodeLevel.put(node.left, level + 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nodeLevel.put(node.right, level + 1);
                }
            }
            levelSum.put(level, sum);
        }

        queue.offer(root);
        root.val = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int level = nodeLevel.get(queue.peek());

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int siblingSum = 0;

                if (node.left != null) {
                    siblingSum += node.left.val;
                }
                if (node.right != null) {
                    siblingSum += node.right.val;
                }

                if (node.left != null) {
                node.left.val = levelSum.get(level + 1) - siblingSum;
                queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = levelSum.get(level + 1) - siblingSum;
                    queue.offer(node.right);
                }

            }
        }
        return root;
    }
}