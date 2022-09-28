/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function (nums) {
  if (nums.length === 1) return nums[0];
  // if the only one element was at the beginning or at the end
  if (nums[0] !== nums[1]) return nums[0];
  if (nums[nums.length - 1] !== nums[nums.length - 2])
    return nums[nums.length - 1];
  let l = 0,
    r = nums.length - 1,
    mid;
  while (l <= r) {
    mid = l + ((r - l) >> 1);
    if (nums[mid] !== nums[mid - 1] && nums[mid] !== nums[mid + 1]) {
      break;
    } else {
      if (mid % 2 === 0) {
        nums[mid] < nums[mid + 1] ? (r = mid) : (l = mid);
      } else {
        nums[mid] < nums[mid + 1] ? (l = mid - 1) : (r = mid + 1);
      }
    }
  }
  return nums[mid];
};
