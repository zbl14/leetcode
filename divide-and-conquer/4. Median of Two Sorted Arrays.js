/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
  if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
  let l = 0,
    r = nums1.length;
  while (l <= r) {
    let i = l + ((r - l) >> 1);
    let j = ((nums1.length + nums2.length + 1) >> 1) - i;
    let nums1Left = i === 0 ? -Infinity : nums1[i - 1];
    let nums1Right = i === nums1.length ? Infinity : nums1[i];
    let nums2Left = j === 0 ? -Infinity : nums2[j - 1];
    let nums2Right = j === nums2.length ? Infinity : nums2[j];
    if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
      if ((nums1.length + nums2.length) % 2 === 0) {
        return (
          (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) /
          2
        );
      } else {
        return Math.max(nums1Left, nums2Left);
      }
    } else if (nums1Right > nums2Left) {
      r = i - 1;
    } else {
      l = i + 1;
    }
  }
};
