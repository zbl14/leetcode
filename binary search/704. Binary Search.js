/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// iterative
// var search = function(nums, target) {
//     let l = 0;
//     let r = nums.length - 1;
//     let mid;
//     while(l <= r){
//         mid = l + ((r - l) >> 1);
//         if(nums[mid] === target) return mid;
//         else nums[mid] < target ? l = mid + 1 : r = mid - 1
//     }
//     return -1;
// };

// recursion
var search = function (nums, target) {
  return binarySearch(nums, 0, nums.length - 1, target);
};

const binarySearch = function (nums, l, r, target) {
  if (l > r) return -1;
  let mid = l + ((r - l) >> 1);
  if (nums[mid] === target) return mid;
  else if (nums[mid] < target) return binarySearch(nums, mid + 1, r, target);
  else return binarySearch(nums, l, mid - 1, target);
};
