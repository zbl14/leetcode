/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
  let i = nums1.length - 1,
    j = nums2.length - 1,
    pos = i + j + 1;
  while (i >= 0 && j >= 0) {
    if (nums1[i] > nums2[j]) {
      nums1[pos] = nums1[i];
      i--;
    } else {
      nums1[pos] = nums2[j];
      j--;
    }
    pos--;
  }
  while (j >= 0) {
    nums1[pos] = nums2[j];
    pos--;
    j--;
  }
  let mid = (nums1.length - 1) >> 1;
  if (nums1.length % 2 === 0) {
    return (nums1[mid] + nums1[mid + 1]) / 2;
  } else {
    return nums1[mid];
  }
};
