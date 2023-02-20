/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function (grid) {
  const q = [];
  let totalFresh = 0;
  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      if (grid[row][col] === 2) q.push([row, col]);
      if (grid[row][col] === 1) totalFresh++;
    }
  }

  let elapsedTime = 0;
  const dirs = [-1, 0, 1, 0, -1];

  while (totalFresh > 0 && q.length > 0) {
    const size = q.length;
    for (let i = 0; i < size; i++) {
      const cur = q.shift();
      for (let k = 0; k < 4; k++) {
        let row = cur[0] + dirs[k];
        let col = cur[1] + dirs[k + 1];
        if (
          row < 0 ||
          row >= grid.length ||
          col < 0 ||
          col >= grid[0].length ||
          grid[row][col] === 2 ||
          grid[row][col] === 0
        )
          continue;
        grid[row][col] = 2;
        q.push([row, col]);
        totalFresh--;
      }
    }
    elapsedTime++;
  }

  return totalFresh === 0 ? elapsedTime : -1;
};
