/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function (intervals) {
  if (intervals.length === 0) {
    return 0;
  }
  intervals.sort((a, b) => a[1] - b[1]);
  let removed = 0,
    prev = intervals[0][1];
  for (let i = 1; i < intervals.length; i++) {
    if (intervals[i][0] < prev) {
      removed++;
    } else {
      prev = intervals[i][1];
    }
  }
  return removed;
};
