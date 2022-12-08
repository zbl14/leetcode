/**
 * @param {number[][]} firstList
 * @param {number[][]} secondList
 * @return {number[][]}
 */
var intervalIntersection = function (firstList, secondList) {
  let i = 0;
  j = 0;
  ans = [];
  while (i < firstList.length && j < secondList.length) {
    let commonStart = Math.max(firstList[i][0], secondList[j][0]);
    let commonEnd = Math.min(firstList[i][1], secondList[j][1]);
    if (commonStart <= commonEnd) ans.push([commonStart, commonEnd]);
    firstList[i][1] < secondList[j][1] ? i++ : j++;
  }
  return ans;
};
