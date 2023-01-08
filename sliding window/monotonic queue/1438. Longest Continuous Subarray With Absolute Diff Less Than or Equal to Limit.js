/**
 * @param {number[]} nums
 * @param {number} limit
 * @return {number}
 */
var longestSubarray = function (nums, limit) {
  const maxQ = [];
  const minQ = [];
  let l = 0,
    res = 0;
  for (let r = 0; r < nums.length; r++) {
    while (maxQ.length && maxQ[maxQ.length - 1] < nums[r]) maxQ.pop();
    while (minQ.length && minQ[minQ.length - 1] > nums[r]) minQ.pop();
    maxQ.push(nums[r]);
    minQ.push(nums[r]);
    if (maxQ[0] - minQ[0] > limit) {
      //当大于limit的时候左指针往右移动，缩小sliding window
      //因此移动过程中的队列若有该元素，需要删除
      if (maxQ[0] === nums[l]) maxQ.shift();
      if (minQ[0] === nums[l]) minQ.shift();
      l++;
    }
    res = Math.max(res, r - l + 1);
  }
  return res;
};
