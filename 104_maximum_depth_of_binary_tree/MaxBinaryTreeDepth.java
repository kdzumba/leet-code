/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
package za.ca.shyftit;

import java.util.Queue;
import java.util.LinkedList;

public class MaxBinaryTreeDepth {
    public static int maxDepthLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            // This is to make sure that we remove all the elements of this level from the queue
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(current != null) {
                    if(current.left != null)
                        queue.add(current.left);
                    if(current.right != null)
                        queue.add(current.right);
                }
            }
            level++;
        }
        return level;
    }

    public static int maxDepthInOrder(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepthInOrder(root.left), maxDepthInOrder(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode fifteen = new TreeNode(15, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode three = new TreeNode(3, nine, twenty);

        System.out.printf("The maximum depth is: %d%n", maxDepthLevelOrder(three));
        System.out.printf("The maximum depth is: %d%n", maxDepthInOrder(three));
    }
}
