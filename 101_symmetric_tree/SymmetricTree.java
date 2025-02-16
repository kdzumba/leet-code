/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */

 package za.ca.shyftit;

 import java.util.Objects;
 import java.util.Stack;
 import java.util.Queue;
 import java.util.LinkedList;
 
 enum Direction {
     LEFT,
     RIGHT
 }
 
 public class SymmetricTree {
     private static final Stack<TreeNode> stack = new Stack<>();
     private static final Queue<TreeNode> queue = new LinkedList<>();
 
     private static void inOrder(TreeNode root, Direction direction) {
         if(root != null) {
             inOrder(root.left, direction);
             if(direction == Direction.LEFT)
                 stack.push(root);
             else
                 queue.offer(root);
             inOrder(root.right, direction);
         }
     }
 
     public static boolean isSymmetric(TreeNode root) {
         inOrder(root.left, Direction.LEFT);
         inOrder(root.right, Direction.RIGHT);
 
         if(stack.size() != queue.size())
             return false;
 
         while(!stack.isEmpty() && !queue.isEmpty()) {
             TreeNode currentL = stack.pop();
             TreeNode currentR = Objects.requireNonNull(queue.poll());
 
             if(currentL.val != currentR.val)
                 return false;
 
             if (checkEquality(currentL, currentR)) return false;
             if (checkEquality(currentR, currentL)) return false;
 
         }
         return true;
     }
 
     private static boolean checkEquality(TreeNode currentL, TreeNode currentR) {
         if(Objects.nonNull(currentL.left)) {
             if(Objects.isNull(currentR.right)) {
                 return true;
             } else {
                 if(currentL.left.val != currentR.right.val)
                     return true;
             }
         } else {
             if(Objects.nonNull(currentR.right)) {
                 return true;
             }
         }
 
         if(Objects.nonNull(currentL.right)) {
             if(Objects.isNull(currentR.left)) {
                 return true;
             } else {
                 return currentL.right.val != currentR.left.val;
             }
         }
         return false;
     }
 
     public static void main(String[] args) {
         TreeNode lThree = new TreeNode(3, null, null);
         TreeNode lFour = new TreeNode(4, null, null);
         TreeNode lTwo = new TreeNode(2, lThree, lFour);
         TreeNode rThree = new TreeNode(3, null, null);
         TreeNode rFour = new TreeNode(4, null, null);
         TreeNode rTwo = new TreeNode(2, rFour, rThree);
         TreeNode root = new TreeNode(1, lTwo, rTwo);
         System.out.println(isSymmetric(root));
     }
 }
 