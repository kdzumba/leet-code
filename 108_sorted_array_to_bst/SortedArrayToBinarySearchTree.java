/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
package za.co.shyftit;

import java.util.Arrays;

public class SortedArrayToBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return new TreeNode(nums[0]);

        TreeNode root = new TreeNode(nums[n / 2]);
        int[] leftSub = Arrays.copyOfRange(nums, 0, n / 2);
        int[] rightSub = Arrays.copyOfRange(nums, n/2 + 1, n);

        if(leftSub.length > 0)
            root.left = sortedArrayToBST(leftSub);
        if(rightSub.length > 0)
            root.right = sortedArrayToBST(rightSub);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode bst = sortedArrayToBST(nums);
        System.out.println(bst.val);
    }
}
