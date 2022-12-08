/**
 * @param {number[][]} slots1
 * @param {number[][]} slots2
 * @param {number} duration
 * @return {number[]}
 */
var minAvailableDuration = function (slots1, slots2, duration) {
  slots1.sort((a, b) => a[0] - b[0]);
  slots2.sort((a, b) => a[0] - b[0]);
  let i = 0;
  j = 0;
  m = slots1.length;
  n = slots2.length;
  while (i < m && j < n) {
    let commonTimeStart = Math.max(slots1[i][0], slots2[j][0]); //共同起始时间，较晚的起始
    let commonTimeEnd = Math.min(slots1[i][1], slots2[j][1]); //共同结束时间，较早的结束
    if (commonTimeEnd - commonTimeStart >= duration) {
      //共同开会时间大于要求的duration
      return [commonTimeStart, commonTimeStart + duration];
    } else if (slots1[i][1] < slots2[j][1]) {
      i++; //结束时间早的换下一个time slot
    } else {
      j++;
    }
  }
  return [];
};
