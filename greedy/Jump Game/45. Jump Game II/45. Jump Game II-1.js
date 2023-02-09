/**
 * @param {number[]} nums
 * @return {number}
 */
// greedy
var jump = function (nums) {
  let curFurthest = 0;
  let curEnd = 0;
  let jumps = 0;
  for (let i = 0; i < nums.length - 1; i++) {
    curFurthest = Math.max(i + nums[i], curFurthest);
    if (i === curEnd) {
      jumps++;
      curEnd = curFurthest;
    }
  }
  return jumps;
};
