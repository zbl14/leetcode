/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function (intervals, newInterval) {
  let res = [];
  let cur = intervals[0];
  for (let i = 0; i < intervals.length; i++) {
    if (newInterval === null || cur[1] < newInterval[0]) {
      res.push(cur);
      cur = intervals[i + 1];
    } else if (cur[0] > newInterval[1]) {
      res.push(newInterval, cur);
      newInterval = null;
      cur = intervals[i + 1];
    } else {
      newInterval[0] = Math.min(newInterval[0], cur[0]);
      newInterval[1] = Math.max(newInterval[1], cur[1]);
      cur = intervals[i + 1];
    }
  }
  if (newInterval != null) res.push(newInterval);
  return res;
};
