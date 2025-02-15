/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

 package za.ca.shyftit;

 import java.util.Queue;
 import java.util.LinkedList;

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

 public class SameTree {
     public static boolean isSameTree(TreeNode p, TreeNode q) {
         if(p.val != q.val)
             return false;
 
         Queue<TreeNode> pQueue = new LinkedList<>();
         Queue<TreeNode> qQueue = new LinkedList<>();
 
         pQueue.add(p);
         qQueue.add(q);
 
         while(!pQueue.isEmpty() && !qQueue.isEmpty()) {
             TreeNode currentP = pQueue.poll();
             TreeNode currentQ = qQueue.poll();
 
             if(currentP == null && currentQ != null || currentP != null && currentQ == null)
                 return false;
 
             if(currentP != null && currentQ != null) {
                 if(currentP.val != currentQ.val)
                     return false;
 
                 pQueue.add(currentP.left);
                 pQueue.add(currentP.right);
                 qQueue.add(currentQ.left);
                 qQueue.add(currentQ.right);
             }
         }
         return true;
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
 
         System.out.println(isSameTree(one, two));
     }
 }
 