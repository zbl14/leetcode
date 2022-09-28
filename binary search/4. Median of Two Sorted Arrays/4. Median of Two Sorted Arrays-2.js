/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */

// using binary search
// i from 0 to m, m >= n (else swap nums1 and nums2)
// consider edge cases
// m+n is odd, return max (nums1[i-1], nums2[j-1])
// m+n is even, return (max(nums1[i-1], nums2[j-1]) + min(nums1[i],nums2[j])) /2

var findMedianSortedArrays = function (nums1, nums2) {
  if (nums1.length > nums2.length) {
    [nums1, nums2] = [nums2, nums1];
  }

  let m = nums1.length;
  let n = nums2.length;

  let totalHalf = Math.floor((m + n + 1) / 2);
  let iMin = 0,
    iMax = m;
  while (iMin <= iMax) {
    let i = (iMin + iMax) >> 1;
    let j = totalHalf - i;
    if (i < m && nums2[j - 1] > nums1[i]) {
      iMin = i + 1;
    } else if (i > 0 && nums1[i - 1] > nums2[j]) {
      iMax = i - 1;
    } else {
      console.log(i, j);
      let maxOfLeft;
      if (i == 0) {
        maxOfLeft = nums2[j - 1];
      } else if (j == 0) {
        maxOfLeft = nums1[i - 1];
      } else {
        maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
      }

      let minOfRight;
      if (i == m) {
        minOfRight = nums2[j];
      } else if (j == n) {
        minOfRight = nums1[i];
      } else {
        minOfRight = Math.min(nums1[i], nums2[j]);
      }

      console.log(maxOfLeft, minOfRight);
      if ((m + n) % 2 === 1) {
        return maxOfLeft;
      }

      return (maxOfLeft + minOfRight) / 2;
    }
  }
};
