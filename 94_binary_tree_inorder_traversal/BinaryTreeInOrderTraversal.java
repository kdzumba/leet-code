package za.ca.shyftit;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 *
 * Output: [1,3,2]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInOrderTraversal {
    private final static List<Integer> results = new ArrayList<>();

    public static List<Integer> inOrderTraversal(TreeNode root) {
        if(root != null) {
            inOrderTraversal(root.left);
            results.add(root.val);
            inOrderTraversal(root.right);
        }
        return results;
    }

    public static List<Integer> inOrderTraversalIterative(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            results.add(current.val);
            current = current.right;
        }

        return results;
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4, null, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode five = new TreeNode(5, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, nine, null);
        TreeNode three = new TreeNode(3, null, eight);
        TreeNode one = new TreeNode(1, two, three);

        System.out.println(inOrderTraversalIterative(one));
        results.clear();
        System.out.println(inOrderTraversal(one));
    }
}
