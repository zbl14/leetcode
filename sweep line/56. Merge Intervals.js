/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
  if (intervals.length === 1) return intervals;
  intervals.sort((a, b) => a[0] - b[0]);
  let res = [];
  let cur = intervals[0];
  for (let i = 0; i < intervals.length - 1; i++) {
    if (cur[1] >= intervals[i + 1][0]) {
      cur[1] = Math.max(cur[1], intervals[i + 1][1]);
    } else {
      res.push(cur);
      cur = intervals[i + 1];
    }
  }
  res.push(cur);
  return res;
};
