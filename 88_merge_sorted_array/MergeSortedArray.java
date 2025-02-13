package za.ca.shyftit;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 */

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;

        if(m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int nums2Ptr = n - 1;
        int nums1Ptr = m - 1;
        int fillPos = nums1.length - 1;

        while(nums2Ptr >= 0 && nums1Ptr >= 0) {
            int toPlace = Math.max(nums1[nums1Ptr], nums2[nums2Ptr]);
            if(toPlace == nums2[nums2Ptr] && nums2[nums2Ptr] != nums1[nums1Ptr]) {
                nums2Ptr--;
            } else {
                nums1Ptr--;
            }
            nums1[fillPos] = toPlace;
            fillPos--;
        }

        if(nums2Ptr >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2Ptr + 1);
        }
    }
}