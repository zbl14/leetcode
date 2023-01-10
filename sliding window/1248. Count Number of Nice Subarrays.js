/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numberOfSubarrays = function (nums, k) {
  return atMost(nums, k) - atMost(nums, k - 1);
};

const atMost = (nums, k) => {
  let l = 0;
  let res = 0;
  let count = 0;
  for (let r = 0; r < nums.length; r++) {
    if (nums[r] % 2 === 1) count++;
    while (count > k) {
      if (nums[l] % 2 === 1) count--;
      l++;
    }
    res += r - l + 1;
  }
  return res;
};
