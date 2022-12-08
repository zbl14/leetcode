/**
 * @param {number[][]} intervals
 * @return {number}
 */
var removeCoveredIntervals = function (intervals) {
  intervals.sort((a, b) => (a[0] !== b[0] ? a[0] - b[0] : b[1] - a[1]));
  let cur = 0;
  let count = 0;
  for (let i = 0; i < intervals.length; i++) {
    if (cur < intervals[i][1]) {
      cur = intervals[i][1];
      count++;
    }
  }
  return count;
};
