/**
 * @param {number[][]} intervals
 * @param {number[]} toBeRemoved
 * @return {number[][]}
 */
var removeInterval = function (intervals, toBeRemoved) {
  let res = [];
  let cur = intervals[0];
  for (let i = 0; i < intervals.length; i++) {
    if (cur[1] < toBeRemoved[0] || cur[0] > toBeRemoved[1]) {
      res.push(cur);
      cur = intervals[i + 1];
    } else {
      if (cur[0] < toBeRemoved[0]) res.push([cur[0], toBeRemoved[0]]);
      if (cur[1] > toBeRemoved[1]) res.push([toBeRemoved[1], cur[1]]);
      cur = intervals[i + 1];
    }
  }
  return res;
};
