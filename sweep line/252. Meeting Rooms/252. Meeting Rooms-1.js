/**
 * @param {number[][]} intervals
 * @return {boolean}
 */

// sweep line
var canAttendMeetings = function (intervals) {
  const timeMapArr = [];
  for (let i = 0; i < intervals.length; i++) {
    timeMapArr.push([intervals[i][0], 1]);
    timeMapArr.push([intervals[i][1], -1]);
  }

  timeMapArr.sort((a, b) => {
    if (a[0] !== b[0]) {
      return a[0] - b[0];
    }
    return a[1] - b[1];
  });

  let count = 0;
  let ans = 0;
  for (let i = 0; i < timeMapArr.length; i++) {
    count += timeMapArr[i][1];
    ans = Math.max(ans, count);
    if (ans > 1) return false;
  }
  return true;
};
