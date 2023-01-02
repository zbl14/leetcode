/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function (nums1, nums2) {
  const result = [];
  for (let i = 0; i < nums1.length; i++) {
    const index = nums2.indexOf(nums1[i]);
    for (let j = index; j < nums2.length; j++) {
      if (nums2[j] > nums1[i]) {
        result.push(nums2[j]);
        break;
      }
      if (j === nums2.length - 1) result.push(-1);
    }
  }
  return result;
};
