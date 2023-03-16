// 4. Median of Two Sorted Arrays;
// TC = O(log(m+n))
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length)
      return findMedianSortedArrays(nums2, nums1);
    int left = 0;
    int right = nums1.length;
    while (left <= right) {
      int i = left + (right - left) / 2;
      int j = (nums1.length + nums2.length + 1) / 2 - i;
      int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
      int nums1Right = (i == nums1.length) ? Integer.MAX_VALUE : nums1[i];
      int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
      int nums2Right = (j == nums2.length) ? Integer.MAX_VALUE : nums2[j];
      if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
        if ((nums1.length + nums2.length) % 2 == 0) {
          return (double) (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2;
        } else {
          return (double) Math.max(nums1Left, nums2Left);
        }
      } else if (nums1Right > nums2Left) {
        right = i - 1;
      } else {
        left = i + 1;
      }
    }
    return -1;
  }
}
