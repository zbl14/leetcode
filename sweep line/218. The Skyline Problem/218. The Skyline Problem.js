/**
 * @param {number[][]} buildings
 * @return {number[][]}
 */
var getSkyline = function (buildings) {
  //use a map, keep get max of current height
  //use Li, -Hi to mark start point
  //use Ri, Hi to mark end point
  //sort Li, Ri
  //if meet start point, push to map
  //get max height till now, if curX diff than preX, add to result
  //if meet end point, remove from map
  let heights = [];
  for (let i = 0; i < buildings.length; i++) {
    const b = buildings[i];
    heights.push([b[0], -b[2]]);
    heights.push([b[1], b[2]]);
  }
  heights.sort((a, b) => (a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]));

  let curHeights = { 0: true };
  let pre = 0,
    res = [];
  for (let i = 0; i < heights.length; i++) {
    const h = heights[i];
    if (h[1] < 0) {
      curHeights[-h[1]] = curHeights[-h[1]] ? curHeights[-h[1]] + 1 : 1;
    } else {
      curHeights[h[1]]--;
      if (curHeights[h[1]] === 0) {
        delete curHeights[h[1]];
      }
    }
    let cur = 0;
    for (const key in curHeights) {
      if (key - 0 > cur) {
        cur = key - 0;
      }
    }

    if (pre !== cur) {
      res.push([h[0], cur]);
      pre = cur;
    }
  }
  return res;
};
