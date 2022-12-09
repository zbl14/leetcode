/**
 * // Definition for an Interval.
 * function Interval(start, end) {
 *    this.start = start;
 *    this.end = end;
 * };
 */

/**
 * @param {Interval[][]} schedule
 * @return {Interval[]}
 */
var employeeFreeTime = function (schedule) {
  let res = [];
  let copy = [];
  for (let employee of schedule) {
    for (let interval of employee) {
      copy.push(interval);
    }
  }
  copy.sort((a, b) => a.start - b.start);
  let temp = copy[0];
  for (element of copy) {
    if (temp.end < element.start) {
      res.push(new Interval(temp.end, element.start));
      temp = element;
    } else {
      temp = temp.end < element.end ? element : temp;
    }
  }
  return res;
};
