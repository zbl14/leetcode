/**
 * @param {number[][]} intervals
 * @return {boolean}
 */

// greedy
var canAttendMeetings = function (intervals) {
  if (intervals.length < 2) return true;
  intervals.sort((a, b) => a[0] - b[0]);
  for (let i = 1; i < intervals.length; i++) {
    if (intervals[i][0] < intervals[i - 1][1]) return false;
  }
  return true;
};
