/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function (cost) {
  let pre1 = 0;
  let pre2 = 0;
  for (let i = 2; i <= cost.length; i++) {
    let cur = Math.min(pre1 + cost[i - 1], pre2 + cost[i - 2]);
    pre2 = pre1;
    pre1 = cur;
  }
  return pre1;
};
